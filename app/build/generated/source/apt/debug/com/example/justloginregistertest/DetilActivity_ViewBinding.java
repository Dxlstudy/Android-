// Generated code from Butter Knife. Do not modify!
package com.example.justloginregistertest;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetilActivity_ViewBinding implements Unbinder {
  private DetilActivity target;

  private View view2131165234;

  @UiThread
  public DetilActivity_ViewBinding(DetilActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetilActivity_ViewBinding(final DetilActivity target, View source) {
    this.target = target;

    View view;
    target.iV = Utils.findRequiredViewAsType(source, R.id.image2, "field 'iV'", ImageView.class);
    target.titleTv = Utils.findRequiredViewAsType(source, R.id.biaoti, "field 'titleTv'", TextView.class);
    target.infoTv = Utils.findRequiredViewAsType(source, R.id.jieshao, "field 'infoTv'", TextView.class);
    target.detaiCommonlist = Utils.findRequiredViewAsType(source, R.id.detail_common_list, "field 'detaiCommonlist'", ListView.class);
    target.commonEt = Utils.findRequiredViewAsType(source, R.id.common_et, "field 'commonEt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.common_btn, "field 'commonBtn' and method 'onClick'");
    target.commonBtn = Utils.castView(view, R.id.common_btn, "field 'commonBtn'", Button.class);
    view2131165234 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.backBtn = Utils.findRequiredViewAsType(source, R.id.fanhui, "field 'backBtn'", Button.class);
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
    target.detaiCommonlist = null;
    target.commonEt = null;
    target.commonBtn = null;
    target.backBtn = null;

    view2131165234.setOnClickListener(null);
    view2131165234 = null;
  }
}
