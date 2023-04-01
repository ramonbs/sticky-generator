import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class ImageGenerator {

    public void creator(InputStream inputStream, String nameArchive) throws Exception {
        //leitura da imagem de forma dinâmica de URLs
        // InputStream inputStream = new URL("url da imagem").openStream();

        // Lendo imagem com imageio.read de arquivo local
        // BufferedImage imageOriginal = ImageIO.read(new File("entrada/figurinha.jpg"));

        // Capturando foto do main
        BufferedImage imageOriginal = ImageIO.read(inputStream);

        // capturando tamanho e largura das imagens
        int width = imageOriginal.getWidth();
        int height = imageOriginal.getHeight();

        int newHeight = height + 200;

        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(imageOriginal, 0, 0, null);

        var font = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);

        graphics.drawString("TOPZERA", 100, newHeight - 300);

        ImageIO.write(newImage, "png", new File("saida/" + nameArchive));
    }

}