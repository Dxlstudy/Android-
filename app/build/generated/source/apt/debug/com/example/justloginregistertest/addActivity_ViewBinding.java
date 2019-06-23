// Generated code from Butter Knife. Do not modify!
package com.example.justloginregistertest;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class addActivity_ViewBinding implements Unbinder {
  private addActivity target;

  private View view2131165275;

  @UiThread
  public addActivity_ViewBinding(addActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public addActivity_ViewBinding(final addActivity target, View source) {
    this.target = target;

    View view;
    target.mFoodName = Utils.findRequiredViewAsType(source, R.id.foodName, "field 'mFoodName'", EditText.class);
    target.mDetail = Utils.findRequiredViewAsType(source, R.id.detail, "field 'mDetail'", EditText.class);
    target.mImage = Utils.findRequiredViewAsType(source, R.id.selectImage, "field 'mImage'", EditText.class);
    target.mCurrentLocation = Utils.findRequiredViewAsType(source, R.id.currentLocation, "field 'mCurrentLocation'", EditText.class);
    view = Utils.findRequiredView(source, R.id.insert, "field 'mInsert' and method 'clickAdd'");
    target.mInsert = Utils.castView(view, R.id.insert, "field 'mInsert'", Button.class);
    view2131165275 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.clickAdd(p0);
      }
    });
    target.mZenjia = Utils.findRequiredViewAsType(source, R.id.zengjia, "field 'mZenjia'", TextView.class);
    target.mFanhuizhuye = Utils.findRequiredViewAsType(source, R.id.fanhuizhuye, "field 'mFanhuizhuye'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    addActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mFoodName = null;
    target.mDetail = null;
    target.mImage = null;
    target.mCurrentLocation = null;
    target.mInsert = null;
    target.mZenjia = null;
    target.mFanhuizhuye = null;

    view2131165275.setOnClickListener(null);
    view2131165275 = null;
  }
}
