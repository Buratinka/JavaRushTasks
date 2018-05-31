package com.javarush.task.task20.task2022;

import java.io.*;

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception
    {

        System.out.println("Closing everything!");
        stream.close();

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {



        Solution solution = new Solution("");
        solution.writeObject("");

        FileOutputStream fos = new FileOutputStream("");
        ObjectOutputStream ous = new ObjectOutputStream(fos);

        ous.writeObject(solution);

        FileInputStream fis = new FileInputStream("");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution solution1 = (Solution) ois.readObject();
        solution1.writeObject("");

    }
}
