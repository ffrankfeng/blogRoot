package test;

import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.RmCommand;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.Set;


/**
 * Hello world!
 */
public class JGitTest {
    //定义本地git路径
    public static final String LOCALPATH = "D:\\javaProgram\\JavaProgram4IDEA\\fengf\\repositories\\fengfRepository\\fengfRepository\\";
    //.git文件路径
    public static final String LOCALGITFILE = LOCALPATH + ".git";
    //远程仓库地址
    public static final String REMOTEREPOURI = "https://github.com/fengf96/fengfRepository.git";//操作git的用户名
    public static final String USER = "fengf96";
    //密码
    public static final String PASSWORD = "970805ff";

    //建立与远程仓库的联系，仅需要执行一次
    public static String setupRepo() {
        String msg = "";
        try {
            Git git = Git.cloneRepository().setURI(REMOTEREPOURI).setCredentialsProvider(new UsernamePasswordCredentialsProvider(USER, PASSWORD)).setBranch("master").setDirectory(new File(LOCALPATH)).call();
            msg = "git init success！";
        } catch (Exception e) {
            msg = "git已经初始化！";
        }
        return msg;
    }

    //pull拉取远程仓库文件
    public static boolean pullBranchToLocal() {
        boolean resultFlag = false;
        //git仓库地址
        Git git;
        try {
            git = new Git(new FileRepository(LOCALGITFILE));
            git.pull().setRemoteBranchName("master").setCredentialsProvider(new UsernamePasswordCredentialsProvider(USER, PASSWORD)).call();
            resultFlag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultFlag;
    }

    public static long copyFile(File f1, File f2) throws IOException {
        long time = new Date().getTime();
        int length = 2097152;
        FileInputStream in = new FileInputStream(f1);
        FileOutputStream out = new FileOutputStream(f2);
        FileChannel inC = in.getChannel();
        FileChannel outC = out.getChannel();
        ByteBuffer b = null;
        while (true) {
            if (inC.position() == inC.size()) {
                inC.close();
                outC.close();
                return new Date().getTime() - time;
            }
            if ((inC.size() - inC.position()) < length) {
                length = (int) (inC.size() - inC.position());
            } else
                length = 2097152;
            b = ByteBuffer.allocateDirect(length);
            inC.read(b);
            b.flip();
            outC.write(b);
            outC.force(false);
        }
    }

    //提交git
    public static boolean commitFiles() {
        try {
            copyFile(new File("C:\\Users\\asus\\Desktop\\favicon.ico"),new File("D:\\javaProgram\\JavaProgram4IDEA\\fengf\\repositories\\fengfRepository\\fengfRepository\\home\\navigation\\favicon.ico"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Git git = null;
        try {
            git = Git.open(new File(LOCALGITFILE));
            AddCommand addCommand = git.add();
            //add操作 add -A操作在jgit不知道怎么用 没有尝试出来 有兴趣的可以看下jgitAPI研究一下 欢迎留言
            addCommand.addFilepattern(".").call();

            RmCommand rm = git.rm();
            Status status = git.status().call();
            //循环add missing 的文件 没研究出missing和remove的区别 就是删除的文件也要提交到git
            Set<String> missing = status.getMissing();
            for (String m : missing) {
                System.out.println("m:" + m);
                rm.addFilepattern(m).call();
                //每次需重新获取rm status 不然会报错
                rm = git.rm();
                status = git.status().call();
            }
            //循环add remove 的文件
            Set<String> removed = status.getRemoved();
            for (String r : removed) {
                System.out.println("r:" + r);
                rm.addFilepattern(r).call();
                rm = git.rm();
                status = git.status().call();
            }
            //提交
            git.commit().setMessage("commit").call();
            //推送
            git.push().setCredentialsProvider(new UsernamePasswordCredentialsProvider(USER, PASSWORD)).call();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        setupRepo();
        pullBranchToLocal();
        commitFiles();

    }
}
