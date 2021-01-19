package org.crazyit.act.c7;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

public class Test01_Zip {

    public static void main(String[] args) throws Exception {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 存储服务
        RepositoryService rs = engine.getRepositoryService();
        
        DeploymentBuilder builder = rs.createDeployment();
        
        FileInputStream fis = new FileInputStream("resource/datas.zip");
        ZipInputStream zis = new ZipInputStream(fis);
        
        builder.addZipInputStream(zis);
        
        builder.deploy();
    }

}
