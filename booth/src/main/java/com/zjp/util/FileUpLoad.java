package com.zjp.util;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
//转存图片
public class FileUpLoad {
    public static String getFileUrl(MultipartFile uploadFile){

        String localDirPath = "D:\\idea\\mybatis_test\\images\\";
        //方式1：利用集合实现数据的校验
        //1、校验文件类型  abc.jpg
        String fileName = uploadFile.getOriginalFilename().toLowerCase();
        //1.1 利用正则表达式校验是否满足图片格式要求
        if (!fileName.matches("^.+\\.(jpg|png|gif)$")){
            return "图片格式错误";
        }

        //2、校验是否为图片对象
        try{
            BufferedImage bufferedImage = ImageIO.read(uploadFile.getInputStream());
            int width=bufferedImage.getWidth();
            int height=bufferedImage.getHeight();

            if (width == 0||height==0){
                return "图片宽高错误";
            }
            //3、实现分目录存储
            //3.1 动态生成hashcode编码 之后2位一隔 生成多级目录，
            // 目录层积太深，笛卡尔较大，遍历不便
            //3.2 可以动态的以当前的时间为存储的目录结构
//            String dateDirPath=
//                    new SimpleDateFormat("/yyyy/MM/dd/").format(new Date());

            //文件的存储目录  E：/JT_IMAGE/2021/01/26/
            File fileDir=new File(localDirPath);
            if (!fileDir.exists()){  //判断文件目录是否存在
                fileDir.mkdirs();   //创建目录
            }

            //4、利用UUID动态生成图片名称   uuid.jpg
            String uuid =
                    UUID.randomUUID().toString().replace("-", "");
            //abc.jpg
            String fileType=fileName.substring(fileName.lastIndexOf("."));
            String newFileName=uuid+fileType;
            System.out.println(newFileName);

            //5、实现文件上传
            File realFile=new File(localDirPath+newFileName);
            uploadFile.transferTo(realFile);
            String urlPort = "http://localhost:8080/res/";
            String url=urlPort+newFileName;
            return url;

        }catch (IOException e){
            e.printStackTrace();
            return "失败";
        }
    }
}
