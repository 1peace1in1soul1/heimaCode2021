package com.yzx;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 文件下载方法
 *
 * 需要引入的包：ganymed-ssh2-build210.jar  下载地址：http://www.ganymed.ethz.ch/ssh2/
 *
 * */
public class FileLoadUtil {

    /**
     *
     * @param dataServerIp 服务器IP
     * @param dataServerUsername 服务器用户名
     * @param dataServerPassword 服务器登录密码
     * @param srcFile 要下载的文件路径
     * @param saveFile 保存路径
     * @param port 端口号
     *
     * return true:下载成功
     */
    public static boolean downLoadFile(String dataServerIp,String dataServerUsername,String dataServerPassword,String srcFile,String saveFile,Integer port){
        boolean flag = false;

        Connection conn = new Connection(dataServerIp);
        Session session = null;
        SCPClient client =null;
        //session=(Session) getObject(dataServerIp, dataServerUsername, dataServerPassword, 0, "session");
        //client=(SCPClient) getObject(dataServerIp, dataServerUsername, dataServerPassword, 0, "client");
        conn=getConn(dataServerIp, dataServerUsername, dataServerPassword, port);
        try {
            session=conn.openSession();
            client=conn.createSCPClient();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            System.out.println("文件开始下载,srcFile:"+srcFile+" saveFile:"+saveFile+" "+Tools.GetCreatetime("yyyy-MM-dd HH:mm:ss"));
            flag = download(srcFile, saveFile, session, client);
            //如果是打包文件，删除包裹
            if (flag) {
                System.out.println("文件打包下载完成！"+" "+Tools.GetCreatetime("yyyy-MM-dd HH:mm:ss"));

            }else {
                System.out.println("文件下载失败！"+" "+Tools.GetCreatetime("yyyy-MM-dd HH:mm:ss"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                session.close();
            } catch (Exception e2) {
            }
            try {
                conn.close();
            } catch (Exception e2) {
            }
        }
        return flag;
    }
    /**
     * 根据不同的需求得到相应的连接
     * @param ip
     * @param userName
     * @param pwd
     * @param port
     * @param whatWant 必须是client或者session
     * @return
     */
    public static Object getObject(String ip,String userName,String pwd,int port,String whatWant){
        Connection conn = new Connection(ip);
        Session session = null;
        SCPClient client =null;
        try {
            conn.connect();
            boolean isAuthenticated = conn.authenticateWithPassword(userName, pwd);
            session=conn.openSession();
            client = new SCPClient(conn);
            if (isAuthenticated == false) {
                throw new IOException("Authentication failed.文件scp到数据服务器时发生异常");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (whatWant!=null&&whatWant.equals("session")) {
            return session;
        }if (whatWant!=null&&whatWant.equals("client")) {
            return client;
        }
        return null;
    }
    /**
     * 获得连接
     * @param ip
     * @param userName
     * @param pwd
     * @param port
     * @return
     */
    public static Connection getConn(String ip,String userName,String pwd,int port){
        Connection conn = new Connection(ip,port);
        boolean blag=false;
        try {
            conn.connect();
            boolean isAuthenticated = conn.authenticateWithPassword(userName, pwd);
            //session=conn.openSession();
            // client = new SCPClient(conn);
            if (isAuthenticated) {
                blag=true;
            }
            if (isAuthenticated == false) {
                throw new IOException("Authentication failed.文件scp到数据服务器时发生异常");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (blag) {
            return conn;
        }else {
            return null;
        }
    }
    /**
     *
     * @param srcFile 要下载的文件
     * @param saveFile 保存目录，必须是目录
     * @param sessionSsh
     * @param client
     * @return
     * @throws UnsupportedEncodingException
     */
    public static boolean download(String srcFile, String saveFile, Session sessionSsh, SCPClient client
    ) throws UnsupportedEncodingException {
        //String cdmTar="tar czf /var/ftp/upload/ruku/ruku.tar.gz –directory=/var/ftp/upload/ruku ruku";
        boolean flag=false;
        // 是文件,直接下载
        try {
            String filename=srcFile.substring(srcFile.lastIndexOf("/")+1);
            if (filename.contains(".")) {
                try {
                    client.get(srcFile, saveFile);
                    flag=true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                //是文件夹，打包下载
                System.out.println("是文件夹,不能下载");
                //unGzipFile(saveFile+"/"+filename+".tar.gz");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    //------------------------------------------------------------------------------------------------------

    /**
     * 构建目录
     * @param outputDir
     * @param subDir
     */
    public static void createDirectory(String outputDir,String subDir){
        File file = new File(outputDir);
        if(!(subDir == null || subDir.trim().equals(""))){//子目录不为空
            file = new File(outputDir + "/" + subDir);
        }
        if(!file.exists()){
            if(!file.getParentFile().exists())
                file.getParentFile().mkdirs();
            file.mkdirs();
        }
    }
}
