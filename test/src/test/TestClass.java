package test;

import android.widget.ListView;
import android.widget.Switch;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;



public class TestClass extends UiAutomatorTestCase {
	
	/ TODO ��Ҫע�⣺ �����иò��Դ����ʱ�� ��Ҫ�Ȱ��ֻ����Ի�������ΪӢ�ġ�
    public void testDemo() throws UiObjectNotFoundException {
 
        // ģ�� HOME ������¼�
        getUiDevice().pressHome();
 
        // ���ڴ�������Ӧ�ã�ģ��������Ӧ�ð�ť��������������Ӧ�ý��档
        // �����ʹ����uiautomatorviewer���鿴����������Է��֡�����Ӧ�á���ť��
        // content-description ����Ϊ��Apps��������ʹ�ø��������ҵ��ð�ť��
        UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
 
        // ģ��������Ӧ�ð�ť�����ȴ�����Ӧ�ý�������
        allAppsButton.clickAndWaitForNewWindow();
 
        // ������Ӧ�ý��棬ʱ��Ӧ��λ��Apps tab�����С�����ģ���û����Apps tab������
        // �ҵ� Apps tab ��ť
        UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
 
        // ģ���� Apps tab.
        appsTab.click();
 
        // Ȼ���� Apps tab���棬ģ���û�������ʱ��Ӧ�õĲ�����
        // ����Apps�����ǿ��Թ����ģ�������
        // UiScrollable ����.
        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
 
        // ���ù���ģʽΪˮƽ����(Ĭ��Ϊ��ֱ����)
        appViews.setAsHorizontalList();
 
        if (allAppsButton.exists() && allAppsButton.isEnabled()) {
            // allAppsButton�ڵ�ǰ�����Ѿ����ɼ��� �������ﲻ��ִ��
            allAppsButton.click();
        }
        // ����ʱ��Ӧ�ò����
        UiObject settingsApp = appViews.getChildByText(
                new UiSelector().className(android.widget.TextView.class.getName()), "Clock");
        settingsApp.clickAndWaitForNewWindow();
 
        // ��֤��ǰ��ʾ ��Ӧ�ð���Ϊʱ��
 
        UiObject settingsValidation = new UiObject(new UiSelector().packageName("com.google.android.deskclock"));
        // ����������������ʾ
        assertTrue("Unable to detect Clock", settingsValidation.exists());
 
        // ģ����ʱ��tab
        UiObject clock = new UiObject(new UiSelector().description("Clock"));
        clock.clickAndWaitForNewWindow();
        // ģ�����·�������ͼ��
        UiObject alarms = new UiObject(new UiSelector().description("Alarms"));
        alarms.clickAndWaitForNewWindow();
 
        UiScrollable list = new UiScrollable(new UiSelector().className(ListView.class.getName()));
        if (list.getChildCount() > 0) {
            UiObject listIndex0 = list.getChild(new UiSelector().index(0));
            UiObject switchBtn = listIndex0.getChild(new UiSelector().className(Switch.class.getName()));
 
            boolean isChecked = switchBtn.isChecked();
 
            switchBtn.click();
        }
        // ģ�������ؼ�
        getUiDevice().pressBack();
 
        UiObject timer = new UiObject(new UiSelector().description("Timer"));
        timer.clickAndWaitForNewWindow();
 
    }


Read more: http://blog.chengyunfeng.com/?p=504#ixzz5a8rjg2UC

}