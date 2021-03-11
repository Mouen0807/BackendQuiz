package com.example.quizrest.Controller;


        
        
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;


import Entities.ImageModel;
import com.example.quizrest.ServiceImpl.ImageModelServicesImpl;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class ImageModelController {

    @Autowired
    ImageModelServicesImpl imageModelServicesImpl;

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @ApiOperation(value="find ImageModel by id")
    @RequestMapping(value = "/ImageModel/id/{id}", method = RequestMethod.GET)
    public ImageModel findImageModelById(@PathVariable Long id) {
        logger.info("find ImageModel by id: "+id);
        ImageModel retrievedImage = imageModelServicesImpl.findById(id);
        retrievedImage.setPicByte(decompressBytes(retrievedImage.getPicByte()));
        return retrievedImage;
    }

    @ApiOperation(value="delete ImageModel by id")
    @RequestMapping(value = "/ImageModel/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable Long id) {
        logger.info("delete ImageModel by id: "+id);
        imageModelServicesImpl.delete(id);
    }

    @ApiOperation(value="get all ImageModels")
    @RequestMapping(value="/ImageModel/all", method = RequestMethod.GET)
    public List<ImageModel> findAllImageModel() {
        logger.info("get all ImageModel");
        return imageModelServicesImpl.findAll();
    }

    @ApiOperation(value="update a ImageModel")
    @RequestMapping(value = "/ImageModel/update", method = RequestMethod.POST)
    public ImageModel updateImageModel(@RequestBody ImageModel imageModel) {
        logger.info("update a ImageModel");
        return imageModelServicesImpl.update(imageModel);
    }

    @ApiOperation(value="upload a ImageModel")
    @RequestMapping(value = "/ImageModel/upload", method = RequestMethod.POST)
    public ResponseEntity<ImageModel> uplaodImage(@RequestBody MultipartFile file) throws IOException {

        logger.info("upload a ImageModel with Original Image Byte Size: "  + file.getBytes().length);
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(), compressBytes(file.getBytes()));
        imageModelServicesImpl.save(img);
        ImageModel responseImageModel=imageModelServicesImpl.save(img);
        if(responseImageModel==null){
            return ResponseEntity.noContent().build();
        }

        URI location= ServletUriComponentsBuilder.fromPath("/ImageModel/id/{id}").
                buildAndExpand(responseImageModel.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    /*
    @PostMapping("ImageModel/upload")
    public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        
        
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(), compressBytes(file.getBytes()));
        imageModelServicesImpl.save(img);
        return ResponseEntity.status(HttpStatus.OK);
        
    }*/

    @ApiOperation(value="find ImageModel by name")
    @RequestMapping( value="/ImageModel/name/{imageName}", method = RequestMethod.GET)
    public ImageModel findAllByName(@PathVariable String imageName)  {

        logger.info("find ImageModel by name: "+imageName);
        final ImageModel retrievedImage = imageModelServicesImpl.findByName(imageName);
        /*ImageModel img = new ImageModel(retrievedImage.getName(), retrievedImage.getType(),
                decompressBytes(retrievedImage.getPicByte()));*/
        return retrievedImage;
    }
    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] buffer = new byte[1024];
        
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer,0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) { }
        logger.info("Compressed Image Byte Size :" + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

        
        // uncompress the image bytes before returning it to the angular application
        
    public static byte[] decompressBytes(byte[] data) {
        
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer,0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
            
        } catch (DataFormatException e) { }

        return outputStream.toByteArray();
        
    }

}