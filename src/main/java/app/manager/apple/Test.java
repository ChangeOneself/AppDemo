package app.manager.apple;

import app.manager.apple.service.FuritFactory;
import org.apache.poi.ss.formula.functions.T;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        FuritFactory<T> furitFactory = (File file) -> file.exists();
        boolean bb = furitFactory.test(new File(""));
    }
}
