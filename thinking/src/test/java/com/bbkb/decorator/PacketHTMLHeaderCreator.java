package com.bbkb.decorator;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/22<br>
 */
public class PacketHTMLHeaderCreator extends PacketDecorator{
    public PacketHTMLHeaderCreator(IPacketCreator packetCreator) {
        super(packetCreator);
    }

    @Override
    public String handleContent() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html>");
        stringBuffer.append("<body>");
        stringBuffer.append(packetCreator.handleContent());
        stringBuffer.append("</body>");
        stringBuffer.append("</html>\n");
        return stringBuffer.toString();
    }
}
