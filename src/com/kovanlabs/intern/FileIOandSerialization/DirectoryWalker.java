package com.kovanlabs.intern.FileIOandSerialization;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirectoryWalker {
    public static void main(String[]args)
    {
        Path startPath = Paths.get(".");
        try{
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>(){

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    long size = Files.size(file);
                    System.out.println(file + " -> "+size+" bytes.");
                    return FileVisitResult.CONTINUE;
                }
            });
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
