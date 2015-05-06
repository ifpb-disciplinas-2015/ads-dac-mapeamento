package br.edu.ifpb.dac.mapeamento.core;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author DouglasGabriel
 */
public class ImagemHandler {

    public byte[] imageToByte(String filePath) throws IOException {
        InputStream is = null;
        byte[] buffer = null;
        is = new FileInputStream(filePath);
        buffer = new byte[is.available()];
        is.read(buffer);
        is.close();
        return buffer;
    }

    public void ByteToImage(byte[] bytes, String filePath) throws Exception {
        byte[] imgBytes = bytes;
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            fos.write(imgBytes);
            FileDescriptor fd = fos.getFD();
            fos.flush();
            fd.sync();
            fos.close();
        } catch (Exception e) {
            throw new Exception("Erro ao converter os bytes recebidos para imagem");
        }
    }
}
