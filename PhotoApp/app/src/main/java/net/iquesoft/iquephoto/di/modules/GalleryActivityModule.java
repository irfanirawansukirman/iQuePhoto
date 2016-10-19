package net.iquesoft.iquephoto.di.modules;

import net.iquesoft.iquephoto.presenter.GalleryActivityPresenterImpl;
import net.iquesoft.iquephoto.view.IGalleryActivityView;

import dagger.Module;
import dagger.Provides;

@Module
public class GalleryActivityModule {

    private IGalleryActivityView mView;

    public GalleryActivityModule(IGalleryActivityView view) {
        mView = view;
    }

    @Provides
    GalleryActivityPresenterImpl provideGalleryActivityPresenterImpl(IGalleryActivityView view) {
        return new GalleryActivityPresenterImpl(mView);
    }

    @Provides
    IGalleryActivityView provideGalleryActivityView() {
        return mView;
    }
}