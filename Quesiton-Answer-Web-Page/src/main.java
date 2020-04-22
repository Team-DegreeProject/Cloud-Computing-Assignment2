import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.List;

public class main {

    public static void main(String args[])  {
//        System.out.println("Hello World!");
        String str=WolframAlpha2.query("2+1");
        System.out.println(str);
        //创建一个新的字符串
        StringReader read = new StringReader(str);
        //创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
        InputSource source = new InputSource(read);
        //创建一个新的SAXBuilder
        SAXBuilder sb = new SAXBuilder();
        //通过输入源构造一个Document
        String content = null;
        try {
            Document doc = sb.build(source);
            Element rootElement = doc.getRootElement();
            System.out.println("------------------------------------");
            List<Element> sections = rootElement.getChildren("section");
            for (int i =0; i<sections.size();i++){
                if(sections.get(i).getChild("title").getText().equals("Result")){
                    System.out.println(sections.get(i).getChild("sectioncontents").getText());
                }

            }
            //取的根元素
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
