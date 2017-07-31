package br.edu.ufcg.partiu;

import android.content.Context;

import br.edu.ufcg.partiu.event.CreateEventComponent;
import br.edu.ufcg.partiu.event.CreateEventModule;
import br.edu.ufcg.partiu.feed.FeedComponent;
import br.edu.ufcg.partiu.login.LoginComponent;
import br.edu.ufcg.partiu.login.LoginModule;
import dagger.Module;
import dagger.Provides;

@Module(
        subcomponents = {
                LoginComponent.class,
                FeedComponent.class,
                CreateEventComponent.class
        }
)
public class AppModule {
    public Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @AppScope
    @Provides
    public Context providesContext() {
        return context;
    }
}
