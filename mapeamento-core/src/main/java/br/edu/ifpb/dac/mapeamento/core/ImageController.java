package br.edu.ifpb.dac.mapeamento.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
public class ImageController {
   
    
    public byte[] getBytes(Path path) throws IOException{
        byte[] bytes = null;
        if(Files.exists(path)){
            try(FileInputStream fis = new FileInputStream(path.toFile())){                
                bytes = new byte[fis.available()];
                int offset = 0;
                while((offset = fis.read(bytes))!=-1){
                    fis.read(bytes, 0, offset);
                }
            }
            
        }
        
        return bytes;
    }
    
    public Path getImage(byte[] bytes) throws IOException{        
        if(bytes != null){
            String prefix = "image";
            String suffix = ".jpg";
            Path tempFile = Files.createTempFile(prefix, suffix);
            Files.write(tempFile, bytes);
            return tempFile; 
        }
        
        return null;
    } 
       
}
