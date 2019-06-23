// Generated code from Butter Knife. Do not modify!
package com.example.justloginregistertest;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetilActivity_ViewBinding implements Unbinder {
  private DetilActivity target;

  @UiThread
  public DetilActivity_ViewBinding(DetilActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetilActivity_ViewBinding(DetilActivity target, View source) {
    this.target = target;

    target.iV = Utils.findRequiredViewAsType(source, R.id.image2, "field 'iV'", ImageView.class);
    target.titleTv = Utils.findRequiredViewAsType(source, R.id.biaoti, "field 'titleTv'", TextView.class);
    target.infoTv = Utils.findRequiredViewAsType(source, R.id.jieshao, "field 'infoTv'", TextView.class);
    target.contentTv = Utils.findRequiredViewAsType(source, R.id.neirong, "field 'contentTv'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DetilActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.iV = null;
    target.titleTv = null;
    target.infoTv = null;
    target.contentTv = null;
  }
}
