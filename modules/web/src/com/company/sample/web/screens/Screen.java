package com.company.sample.web.screens;

import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.chile.core.model.MetaPropertyPath;
import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

public class Screen extends AbstractWindow {
    @Inject
    private Table<User> sampleTable;
    @Inject
    private CollectionDatasource<User, UUID> usersDs;
    
    @Override
    public void init(Map<String, Object> params) {
        MetaPropertyPath userVersionPropertyPath = 
                usersDs.getMetaClass().getPropertyPath("login");
        sampleTable.unwrap(com.vaadin.ui.Table.class)
                .setFooterVisible(true);
        sampleTable.unwrap(com.vaadin.ui.Table.class)
                .setColumnFooter(userVersionPropertyPath, "constant footer value");
    }
}