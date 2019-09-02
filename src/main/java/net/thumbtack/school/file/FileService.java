package net.thumbtack.school.file;

import com.google.gson.Gson;
import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;
import net.thumbtack.school.figures.v3.Rectangle;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;
import org.apache.commons.io.IOUtils;
import sun.tools.jconsole.inspector.XObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

public class FileService {

    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(array);
        fileOutputStream.close();
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(array);
        fileOutputStream.close();
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        return IOUtils.toByteArray(fileInputStream);
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        return IOUtils.toByteArray(fileInputStream);
    }


    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                byteArrayOutputStream1.write(array[i]);
            }
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream1.toByteArray());


        byteArrayInputStream.close();
        byteArrayOutputStream1.close();
        return IOUtils.toByteArray(byteArrayInputStream);
    }


    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName));
        bufferedOutputStream.write(array);
        bufferedOutputStream.close();
    }


    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        writeByteArrayToBinaryFileBuffered(file.toString(), array);
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName));
        return IOUtils.toByteArray(bufferedInputStream);
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        return IOUtils.toByteArray(bufferedInputStream);
    }


    public static void writeRectangleToBinaryFile(File file, Rectangle rect) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        dataOutputStream.writeInt(rect.getTopLeft().getX());
        dataOutputStream.writeInt(rect.getTopLeft().getY());
        dataOutputStream.writeInt(rect.getBottomRight().getX());
        dataOutputStream.writeInt(rect.getBottomRight().getY());
        dataOutputStream.close();
    }


    public static Rectangle readRectangleFromBinaryFile(File file) throws IOException {
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            return new Rectangle(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readInt(), Color.RED);
        } catch (ColorException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void writeRectangleArrayToBinaryFile(File file, Rectangle[] rects) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        for (Rectangle rect : rects) {
            dataOutputStream.writeInt(rect.getTopLeft().getX());
            dataOutputStream.writeInt(rect.getTopLeft().getY());
            dataOutputStream.writeInt(rect.getBottomRight().getX());
            dataOutputStream.writeInt(rect.getBottomRight().getY());
        }
    }


    public static Rectangle[] readRectangleArrayFromBinaryFileReverse(File file) throws IOException {
        Rectangle[] rectangles = new Rectangle[(int) (file.length() / 16)];
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            for (int i = (int) (file.length() / 16) - 1; i >= 0; i--) {
                rectangles[i] = new Rectangle(dataInputStream.readInt(), dataInputStream.readInt(),
                        dataInputStream.readInt(), dataInputStream.readInt(), Color.RED);
            }
        } catch (ColorException e) {
            e.printStackTrace();
        }
        return rectangles;
    }


    public static void writeRectangleToTextFileOneLine(File file, Rectangle rect) throws IOException {
        try (PrintStream printStream = new PrintStream(file)) {
            printStream.printf("%d %d %d %d", rect.getTopLeft().getX(), rect.getTopLeft().getY(),
                    rect.getBottomRight().getX(), rect.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromTextFileOneLine(File file) throws IOException, ColorException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] str = br.readLine().split(" ");
            return new Rectangle(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3]), Color.RED);
        }
    }


    public static void writeRectangleToTextFileFourLines(File file, Rectangle rect) throws IOException {
        try (PrintStream printStream = new PrintStream(file)) {
            printStream.printf("%d\n%d\n%d\n%d\n", rect.getTopLeft().getX(), rect.getTopLeft().getY(),
                    rect.getBottomRight().getX(), rect.getBottomRight().getY());
        }
    }


    public static Rectangle readRectangleFromTextFileFourLines(File file) throws IOException, ColorException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] strings = new String[(int) (file.length() / 4)];
            for (int i = 0; i < strings.length - 1; i++) {
                strings[i] = br.readLine();
            }
            return new Rectangle(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), Integer.parseInt(strings[2]),
                    Integer.parseInt(strings[3]), Color.RED);
        }
    }


    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException {
        try (PrintStream printStream = new PrintStream(file, String.valueOf(StandardCharsets.UTF_8))) {
            printStream.printf("%s %s %d", trainee.getFirstName(), trainee.getLastName(), trainee.getRating());
        }
    }


    public static Trainee readTraineeFromTextFileOneLine(File file) throws IOException, TrainingException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String[] strings = bufferedReader.readLine().split(" ");
            return new Trainee(strings[0], strings[1], Integer.parseInt(strings[2]));
        }
    }


    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        try (PrintStream printStream = new PrintStream(file, String.valueOf(StandardCharsets.UTF_8))) {
            printStream.printf("%s\n%s\n%d\n", trainee.getFirstName(), trainee.getLastName(), trainee.getRating());
        }
    }


    public static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException,TrainingException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] strings = new String[3];
            for (int i = 0; i < strings.length; i++) {
                strings[i] = br.readLine();
            }
            return new Trainee(strings[0], strings[1], Integer.parseInt(strings[2]));
        }
    }


    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(trainee);
        }
    }


    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException, ClassNotFoundException {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            return (Trainee) objectInputStream.readObject();
        }
    }


    public static String serializeTraineeToJsonString(Trainee trainee) {
        return new Gson().toJson(trainee);
    }


    public static Trainee deserializeTraineeFromJsonString(String json) {
        return new Gson().fromJson(json,Trainee.class);
    }


    public static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException{
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(serializeTraineeToJsonString(trainee));
        }
    }


    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            return deserializeTraineeFromJsonString(objectInputStream.readObject().toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

