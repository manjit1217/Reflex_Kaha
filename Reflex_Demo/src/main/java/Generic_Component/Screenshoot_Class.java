package Generic_Component;



import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;

public class Screenshoot_Class extends Base_class {
 
  static String scrShotDir = "screenshots";
  File scrFile;
  static File scrShotDirPath = new java.io.File("./"+ scrShotDir+ "//");
  static String destFile;
  public static String result = null;
  //static AndroidDriver driver = null;
 
 public static String readToastMessage() throws TesseractException {
  String imgName = takeScreenShot();
  
  File imageFile = new File(scrShotDirPath, imgName);
  System.out.println("Image name is :" + imageFile.toString());
  ITesseract instance = new Tesseract();

  File tessDataFolder = LoadLibs.extractTessResources("tessdata"); // Extracts
                   // Tessdata
                   // folder
                   // from
                   // referenced
                   // tess4j
                   // jar
                   // for
                   // language
                   // support
  instance.setDatapath(tessDataFolder.getAbsolutePath()); // sets tessData
                // path

  result = instance.doOCR(imageFile);
  //System.out.println("old one"+result);
  return result;
 }

 /**
  * Takes screenshot of active screen
  * 
  * @return ImageFileName
  */
 public static String takeScreenShot() {
  File scrFile = ((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.FILE); 
  
  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
  new File(scrShotDir).mkdirs(); // Create folder under project with name
          // "screenshots" if doesn't exist
  destFile = dateFormat.format(new Date()) + ".png"; // Set file name
               // using current
               // date time.
  try {
   FileUtils.copyFile(scrFile, new File(scrShotDir + "/" + destFile)); // Copy
                    // paste
                    // file
                    // at
                    // destination
                    // folder
                    // location
  } catch (IOException e) {
   System.out.println("Image not transfered to screenshot folder");
   e.printStackTrace();
  }
  return destFile;
 }
}