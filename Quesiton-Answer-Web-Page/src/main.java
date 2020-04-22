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
        //����һ���µ��ַ���
        StringReader read = new StringReader(str);
        //�����µ�����ԴSAX ��������ʹ�� InputSource ������ȷ����ζ�ȡ XML ����
        InputSource source = new InputSource(read);
        //����һ���µ�SAXBuilder
        SAXBuilder sb = new SAXBuilder();
        //ͨ������Դ����һ��Document
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
            //ȡ�ĸ�Ԫ��
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
