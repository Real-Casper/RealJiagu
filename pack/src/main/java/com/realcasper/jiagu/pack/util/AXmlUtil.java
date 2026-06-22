package com.realcasper.jiagu.pack.util;

import static com.realcasper.jiagu.pack.core.AppManager.PROXY_APPLICATION_NAME;

import java.io.File;

import com.realcasper.jiagu.pack.util.axml.meditor.core.FileProcesser;
import com.realcasper.jiagu.pack.util.axml.meditor.property.AttributeItem;
import com.realcasper.jiagu.pack.util.axml.meditor.property.ModificationProperty;
import com.realcasper.jiagu.pack.util.axml.meditor.utils.NodeValue;

public class AXmlUtil {
    public static String updateManifest(String manifest) {
        ModificationProperty property = new ModificationProperty();

        property.addApplicationAttribute(new AttributeItem(NodeValue.Application.NAME, PROXY_APPLICATION_NAME));

        File file = new File(manifest);
        File temp = new File(manifest + "_bak");
        file.renameTo(temp);

        // 处理manifest文件方法
        String application = FileProcesser.processManifestFile(temp.getPath(), manifest, property);
        temp.delete();

        return application;
    }

}
