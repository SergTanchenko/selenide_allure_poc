package com.stanchenko.lib;

import org.junit.runner.notification.Failure;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.junit.AllureRunListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Sergii Tanchenko on 05.03.2015.
 */
public class OnFailListener extends AllureRunListener {

	@Override
	public void testFailure(Failure failure) {
		makeScreenShot();
		if (failure.getDescription().isTest()) {
			fireTestCaseFailure(failure.getException());
		} else {
			startFakeTestCase(failure.getDescription());
			fireTestCaseFailure(failure.getException());
			finishFakeTestCase();
		}
	}

	@Attachment(type = "image/png")
	public byte[] makeScreenShot() {
		return captureScreenShot();
	}

	private byte[] captureScreenShot() {
		try {
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "png", baos);
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			return imageInByte;
		} catch (IOException | AWTException e) {
			e.printStackTrace();
		}
		return "Attachment Content Empty, can't create screenshot".getBytes();
	}
}
