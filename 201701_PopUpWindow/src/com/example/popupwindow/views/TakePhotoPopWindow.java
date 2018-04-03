package com.example.popupwindow.views;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.popupwindow.R;

public class TakePhotoPopWindow extends PopupWindow
{

	private Context mContext;
	private View view;
	private Button btn_take_photo, btn_pick_photo, btn_cancel;

	public TakePhotoPopWindow(Context mContext, View.OnClickListener itemsOnClick)
	{
		this.view = LayoutInflater.from(mContext).inflate(R.layout.take_photo_pop, null);

		btn_take_photo = (Button) view.findViewById(R.id.btn_take_photo);
		btn_pick_photo = (Button) view.findViewById(R.id.btn_pick_photo);
		btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
		btn_cancel.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				dismiss();
			}
		});
		// ���ð�ť����
		btn_pick_photo.setOnClickListener(itemsOnClick);
		btn_take_photo.setOnClickListener(itemsOnClick);

		// �����ⲿ�ɵ��
		this.setOutsideTouchable(true);
		// mMenuView���OnTouchListener�����жϻ�ȡ����λ�������ѡ������������ٵ�����
		this.view.setOnTouchListener(new View.OnTouchListener()
		{

			public boolean onTouch(View v, MotionEvent event)
			{

				int height = view.findViewById(R.id.pop_layout).getTop();

				int y = (int) event.getY();
				if (event.getAction() == MotionEvent.ACTION_UP)
				{
					if (y < height)
					{
						dismiss();
					}
				}
				return true;
			}
		});

		/* ���õ����������� */
		// ������ͼ
		this.setContentView(this.view);
		// ���õ�������Ŀ�͸�
		this.setHeight(RelativeLayout.LayoutParams.MATCH_PARENT);
		this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);

		// ���õ�������ɵ��
		this.setFocusable(true);

		// ʵ����һ��ColorDrawable��ɫΪ��͸��
		ColorDrawable dw = new ColorDrawable(0xb0000000);
		// ���õ�������ı���
		this.setBackgroundDrawable(dw);

		// ���õ���������ʾʱ�Ķ������ӵײ����ϵ���
		this.setAnimationStyle(R.style.take_photo_anim);

	}

}
