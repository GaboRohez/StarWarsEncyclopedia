package xyz.gaborohez.starwarsencyclopedia.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import xyz.gaborohez.starwarsencyclopedia.R;

public class StarWarsApplication  extends Application {

    private static Context context;
    public static AndroidResourceManager androidResourceManager;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        androidResourceManager = new AndroidResourceManager(getResources());
    }

    public static Context getAppContext() {
        return context;
    }

    public class AndroidResourceManager {

        private Resources resources;

        public AndroidResourceManager(Resources resources) {
            this.resources = resources;
        }

        public String getErrorMessage() {
            return resources.getString(R.string.error_in_response);
        }

        public String getEmptyListError(){
            return resources.getString(R.string.empty_list_message);
        }
    }
}
