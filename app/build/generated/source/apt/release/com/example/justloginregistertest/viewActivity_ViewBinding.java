// Generated code from Butter Knife. Do not modify!
package com.example.justloginregistertest;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class viewActivity_ViewBinding implements Unbinder {
  private viewActivity target;

  @UiThread
  public viewActivity_ViewBinding(viewActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public viewActivity_ViewBinding(viewActivity target, View source) {
    this.target = target;

    target.mTitle = Utils.findRequiredViewAsType(source, R.id.title, "field 'mTitle'", EditText.class);
    target.mImag = Utils.findRequiredViewAsType(source, R.id.image, "field 'mImag'", EditText.class);
    target.mWeizhi = Utils.findRequiredViewAsType(source, R.id.weizhi, "field 'mWeizhi'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    viewActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTitle = null;
    target.mImag = null;
    target.mWeizhi = null;
  }
}
