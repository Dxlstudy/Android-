// Generated code from Butter Knife. Do not modify!
package com.example.justloginregistertest;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegisterActivity_ViewBinding implements Unbinder {
  private RegisterActivity target;

  private View view2131165273;

  private View view2131165221;

  @UiThread
  public RegisterActivity_ViewBinding(RegisterActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RegisterActivity_ViewBinding(final RegisterActivity target, View source) {
    this.target = target;

    View view;
    target.mRlRegisteractivityTop = Utils.findRequiredViewAsType(source, R.id.rl_registeractivity_top, "field 'mRlRegisteractivityTop'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.iv_registeractivity_back, "field 'mIvRegisteractivityBack' and method 'onClick'");
    target.mIvRegisteractivityBack = Utils.castView(view, R.id.iv_registeractivity_back, "field 'mIvRegisteractivityBack'", ImageView.class);
    view2131165273 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mLlRegisteractivityBody = Utils.findRequiredViewAsType(source, R.id.ll_registeractivity_body, "field 'mLlRegisteractivityBody'", LinearLayout.class);
    target.mEtRegisteractivityUsername = Utils.findRequiredViewAsType(source, R.id.et_registeractivity_username, "field 'mEtRegisteractivityUsername'", EditText.class);
    target.mEtRegisteractivityPassword1 = Utils.findRequiredViewAsType(source, R.id.et_registeractivity_password1, "field 'mEtRegisteractivityPassword1'", EditText.class);
    target.mEtRegisteractivityPassword2 = Utils.findRequiredViewAsType(source, R.id.et_registeractivity_password2, "field 'mEtRegisteractivityPassword2'", EditText.class);
    target.mRlRegisteractivityBottom = Utils.findRequiredViewAsType(source, R.id.rl_registeractivity_bottom, "field 'mRlRegisteractivityBottom'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.bt_registeractivity_register, "method 'onClick'");
    view2131165221 = view;
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
    RegisterActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRlRegisteractivityTop = null;
    target.mIvRegisteractivityBack = null;
    target.mLlRegisteractivityBody = null;
    target.mEtRegisteractivityUsername = null;
    target.mEtRegisteractivityPassword1 = null;
    target.mEtRegisteractivityPassword2 = null;
    target.mRlRegisteractivityBottom = null;

    view2131165273.setOnClickListener(null);
    view2131165273 = null;
    view2131165221.setOnClickListener(null);
    view2131165221 = null;
  }
}
