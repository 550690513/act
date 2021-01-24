package org.crazyit.act.c0_dataInit;

import org.activiti.engine.ProcessEngineConfiguration;

public class CleanData {

    public static void main(String[] args) {
        ProcessEngineConfiguration config = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
        config.setDatabaseSchemaUpdate("drop-create");
        config.buildProcessEngine();
    }

}
