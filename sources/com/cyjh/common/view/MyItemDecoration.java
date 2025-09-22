package com.cyjh.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MyItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private Paint f1807a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f1808b;

    /* renamed from: c  reason: collision with root package name */
    private int f1809c;
    private int d = 1;
    private int e = 1;

    private MyItemDecoration(Context context, int i) {
        a(context, i);
    }

    private MyItemDecoration(Context context, int i, int i2, int i3) {
        this.f1809c = i2;
        this.d = i3;
        a(context, i);
    }

    private void a(int i) {
        this.f1807a.setColor(i);
    }

    private void a(Context context) {
        this.f1807a = new Paint();
        this.f1807a.setFlags(1);
        this.f1807a.setStyle(Paint.Style.FILL);
        this.f1807a.setColor(context.getResources().getColor(this.f1809c));
    }

    private void a(Context context, int i) {
        this.e = i;
        if (i == 0 || i == 1) {
            this.e = i;
            this.f1807a = new Paint();
            this.f1807a.setFlags(1);
            this.f1807a.setStyle(Paint.Style.FILL);
            this.f1807a.setColor(context.getResources().getColor(this.f1809c));
            return;
        }
        throw new IllegalArgumentException("请输入正确的参数");
    }

    private void a(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int measuredWidth = recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            canvas.drawRect((float) paddingLeft, (float) bottom, (float) measuredWidth, (float) (this.d + bottom), this.f1807a);
        }
    }

    private void b(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
            canvas.drawRect((float) right, (float) paddingTop, (float) (this.d + right), (float) childAt.getBottom(), this.f1807a);
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (this.e == 1) {
            rect.set(0, 0, 0, this.d);
        } else {
            rect.set(0, 0, this.d, 0);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        int i = 0;
        if (this.e == 0) {
            int paddingTop = recyclerView.getPaddingTop();
            int childCount = recyclerView.getChildCount();
            while (i < childCount) {
                View childAt = recyclerView.getChildAt(i);
                int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
                canvas.drawRect((float) right, (float) paddingTop, (float) (this.d + right), (float) childAt.getBottom(), this.f1807a);
                i++;
            }
            return;
        }
        int paddingLeft = recyclerView.getPaddingLeft();
        int measuredWidth = recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight();
        int childCount2 = recyclerView.getChildCount();
        while (i < childCount2) {
            View childAt2 = recyclerView.getChildAt(i);
            int bottom = childAt2.getBottom() + ((RecyclerView.LayoutParams) childAt2.getLayoutParams()).bottomMargin;
            canvas.drawRect((float) paddingLeft, (float) bottom, (float) measuredWidth, (float) (this.d + bottom), this.f1807a);
            i++;
        }
    }
}
