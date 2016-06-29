package cn.jiajixin.nuwasample;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import java.io.File;

import cn.jiajixin.nuwa.Nuwa;

/**
 * Created by jixin.jia on 15/11/2.
 */
public class NuwaApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        initNuwa();
    }

    private void initNuwa() {
        File fixPath = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getPackageName());
        try {
            if (!fixPath.exists())
                fixPath.mkdirs();
        } catch (Exception e) {

        }
        Nuwa.init(this);
        Nuwa.loadPatch(this, Environment.getExternalStorageDirectory().getAbsolutePath().concat("/" + getPackageName() + "/patch.jar"));
    }
}
