// Generated code from Butter Knife. Do not modify!
package com.example.justloginregistertest;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131165319;

  private View view2131165290;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.searchTextEt = Utils.findRequiredViewAsType(source, R.id.seachtext, "field 'searchTextEt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.search, "field 'searchIB' and method 'onClick'");
    target.searchIB = Utils.castView(view, R.id.search, "field 'searchIB'", ImageButton.class);
    view2131165319 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.addIb = Utils.findRequiredViewAsType(source, R.id.add, "field 'addIb'", ImageButton.class);
    view = Utils.findRequiredView(source, R.id.logout, "field 'mBtMainLogout' and method 'onClick'");
    target.mBtMainLogout = Utils.castView(view, R.id.logout, "field 'mBtMainLogout'", Button.class);
    view2131165290 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.searchTextEt = null;
    target.searchIB = null;
    target.addIb = null;
    target.mBtMainLogout = null;

    view2131165319.setOnClickListener(null);
    view2131165319 = null;
    view2131165290.setOnClickListener(null);
    view2131165290 = null;
  }
}
