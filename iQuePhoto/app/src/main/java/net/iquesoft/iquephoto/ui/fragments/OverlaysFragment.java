package net.iquesoft.iquephoto.ui.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;

import net.iquesoft.iquephoto.R;
import net.iquesoft.iquephoto.adapter.OverlaysAdapter;
import net.iquesoft.iquephoto.core.editor.ImageEditorView;
import net.iquesoft.iquephoto.presentation.common.ToolFragment;
import net.iquesoft.iquephoto.models.Overlay;
import net.iquesoft.iquephoto.presentation.presenters.fragment.OverlaysPresenter;
import net.iquesoft.iquephoto.presentation.views.fragment.OverlaysView;
import net.iquesoft.iquephoto.util.ToolbarUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static net.iquesoft.iquephoto.core.editor.enums.EditorTool.OVERLAY;

public class OverlaysFragment extends ToolFragment implements OverlaysView {
    @InjectPresenter
    OverlaysPresenter mPresenter;

    @BindView(R.id.overlayRecyclerView)
    RecyclerView mRecyclerView;

    private Unbinder mUnbinder;

    private ImageEditorView mImageEditorView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageEditorView =
                (ImageEditorView) getActivity().findViewById(R.id.imageEditorView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overlay, container, false);

        mUnbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ToolbarUtil.updateTitle(R.string.overlay, getActivity());
        mImageEditorView.changeTool(OVERLAY);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void setupAdapter(List<Overlay> overlays) {
        OverlaysAdapter adapter = new OverlaysAdapter(overlays);
        adapter.setOnOverlayClickListener(overlay ->
                mPresenter.changeOverlay(getContext(), overlay)
        );

        mRecyclerView.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false)
        );
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onOverlayChanged(Bitmap bitmap) {
        mImageEditorView.setOverlay(bitmap);
    }
}
