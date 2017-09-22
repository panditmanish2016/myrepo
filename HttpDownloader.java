/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopappsfordesktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.RandomAccessFile;
 class HttpDownloadUtility {
    private static final int BUFFER_SIZE = 4096;
    public static void downloadFile(String fileURL, String saveDir)
            throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();
        boolean flag=true;
        boolean flag1=true;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();
            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10,
                            disposition.length() - 1);
                }
            } else {
                // extracts file name from URL
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
                        fileURL.length());
            }
            System.out.println("Content-Type = " + contentType);
            System.out.println("Content-Disposition = " + disposition);
            System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + fileName);
            //	 to import from folder		
			File file=new 	File("D:\\DownloadFromNet");
                        long downloadedSize=0;
                        long contentLengthLong=0;
                        BufferedInputStream input;
                        RandomAccessFile output;
                        System.out.println("fileS = " + file);
                        httpConn.disconnect();
                        httpConn = (HttpURLConnection) url.openConnection();
			   for ( File f : file.listFiles()) 
			   {
                              if(f.exists()&& !f.isDirectory())
                               { 
                              System.out.println("filesName = " + f.getName()); 
                              if(f.getName().equalsIgnoreCase(fileName))
					 {
                                             flag1=true;
                                              flag=false;
                                              System.out.println("length from disk "+f.length()+" length from http "+contentLength );
						 if(f.length()!=contentLength)
						 {
							  System.out.println("file length of unsuccessfull");
                                                          flag=false;
                                                            flag1=true;
                                                          // to resume downlaod 
                                                     
                                                         httpConn.setAllowUserInteraction(true);
                                                          httpConn.setRequestProperty("Range", "bytes=" + f.length() + "-");
                                                           String connectionField = httpConn.getHeaderField("content-range");
                                                           System.out.println("connectionField "+connectionField);

                                                           if (connectionField != null)
                                                             {
                                                          String[] connectionRanges = connectionField.substring("bytes=".length()).split("-");
                                                          downloadedSize = Long.valueOf(connectionRanges[0]);
                                                          System.out.println("downloadedSize "+downloadedSize);
                                                             } 
                                                           
                                                           contentLengthLong = httpConn.getContentLength() + downloadedSize;
                                                            System.out.println("File downloade contentLengthLong "+contentLengthLong);
                                                           input = new BufferedInputStream(httpConn.getInputStream());
                                                           output = new RandomAccessFile(f, "rw");
                                                           output.seek(downloadedSize);
                                                           byte data[] = new byte[BUFFER_SIZE];
                                                           int count = 0;
                                                           int __progress = 0;
                                                           while ((count = input.read(data, 0, BUFFER_SIZE)) != -1 && __progress != 100) 
                                                               {
                                                               downloadedSize += count;
                                                                output.write(data, 0, count);
                                                                 __progress = (int)((downloadedSize * 100) / contentLengthLong);
                                                               }
                                                            System.out.println("File downloade __progress "+__progress);
                                                            output.close();
                                                            input.close();
                                                           /* System.out.println("File download");
			                                    String completePath=saveDir+"/"+fileName;
			                                    if (Desktop.isDesktopSupported()) 
                                                             {
                                                             Desktop.getDesktop().open(new File(completePath));
                                                              }
                                                            else 
                                                              {
                                                             System.out.println("No file to download. Server replied HTTP code: " + responseCode);
                                                              }*/
                                                            
						 }  
					 }
                              } 
                             // to fresh download
                           }
                             if(flag)
                   {
                        System.out.println("Flag is calling new file download");
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;
            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
 
            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
                /*if(outputStream.getChannel().size()==contentLength)
                {
                    System.out.println(outputStream.getChannel().size()+" "+contentLength+" File downloaded successfully");
                }
                else
                {
                 System.out.println(" "+contentLength+" File downloaded unsuccessfully");
                }*/
            outputStream.close();
            inputStream.close();
            System.out.println("File downloaded");
                } 
                             
                  if(flag1)
                  {
                       System.out.println("Flag1 is calling to play file downloaded");
                 String completePath=saveDir+"/"+fileName;
			if (Desktop.isDesktopSupported()) 
                        {
                        Desktop.getDesktop().open(new File(completePath));
                        }
                       else 
                        {
                       System.out.println("No file to download. Server replied HTTP code: " + responseCode);
                        } 
                  }
                      
        httpConn.disconnect();
        }
    }
}
public class HttpDownloader {
     public static void main(String[] args) {
        String fileURL = "https://freehd.in/music/hindi_video/Oonchi_Hai_Building_2.0_Judwaa_2/Oonchi_Hai_UHD.mp4";
       // String fileURL=  "http://www.sample-videos.com/video/mp4/720/big_buck_bunny_720p_30mb.mp4";
		String saveDir = "D:\\DownloadFromNet";
		File files = new File(saveDir);
        if (!files.exists()) {
         files.mkdirs();
                }
        try {
            HttpDownloadUtility.downloadFile(fileURL, saveDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
