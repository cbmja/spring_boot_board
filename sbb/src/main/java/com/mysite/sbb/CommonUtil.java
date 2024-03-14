package com.mysite.sbb;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {
	
	/**
	 * 마크다운 문법이 포함된 텍스트를 html로 변환하여 리턴해줌
	 * @param markdown
	 * @return
	 */
	public String markdown(String markdown) {
		Parser parser = Parser.builder().build();
		Node document = parser.parse(markdown);
		HtmlRenderer renderer = HtmlRenderer.builder().build();
		return renderer.render(document);
	}
}