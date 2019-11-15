package ru.stqa.yasen.testenv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.stqa.yasen.Browser;
import ru.stqa.yasen.Window;

@ExtendWith(FixtureSetup.class)
public class TestBase {

  protected TestEnvironment env;
  protected Browser browser;
  protected Window mainWin;

  @BeforeEach
  void initFixture(Fixture fixture) {
    env = fixture.getTestEnv();
    browser = fixture.getBrowser();

    mainWin = browser.currentWindow();
    browser.windows().stream()
      .filter(w -> ! w.equals(mainWin))
      .forEach(Window::close);
  }

}