import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.wm.ToolWindow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ReadIssue extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {




        @Nullable Editor contentExeptions = e.getData(PlatformDataKeys.EDITOR);
        String selectedText = contentExeptions.getSelectionModel().getSelectedText();
        Messages.showMessageDialog(selectedText,"Title",Messages.getInformationIcon());  // Visualisation of the selected text
        System.out.println(selectedText);
        String encoded = "";
        try {
           encoded = URLEncoder.encode(selectedText, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        String url = String.format(encoded) ;

        //BrowserUtil.browse(url);
    }

    @Override
    public boolean isDumbAware() {
        return false;
    }
}
