package com.blumbit.restaurant_service.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.blumbit.restaurant_service.dto.response.PedidoResponseDto;

@Service
public class PdfService {

    private final SpringTemplateEngine springTemplateEngine;

    private final IPedidoService pedidoService;

    public PdfService(IPedidoService pedidoService, SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
        this.pedidoService = pedidoService;
    }

    private File generatePedidoPdf() {
        Context context = getContextPedidoPdf();
        String html = loadAndFillTemplate(context);
        String xhtml = convertToXhtml(html);
        return renderPedidosPdf(xhtml);
    }

    private String convertToXhtml(String html) {
        Tidy tidy = new Tidy();
        tidy.setXHTML(true);
        tidy.setIndentContent(true);
        tidy.setInputEncoding("UTF-8");
        tidy.setOutputEncoding("UTF-8");
        tidy.setShowWarnings(false);
        tidy.setTidyMark(false);

        Document htmlDOM = tidy.parseDOM(new ByteArrayInputStream(html.getBytes()), null);
        OutputStream outputStream = new ByteArrayOutputStream();
        tidy.pprint(htmlDOM, outputStream);
        return outputStream.toString();
    }

    private File renderPedidosPdf(String xhtml) throws IOException {
        File file = File.createTempFile("pedidos", "pdf");
        OutputStream outputStream = new FileOutputStream(file);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(xhtml);
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
        file.deleteOnExit();
        return file;
    }

    private Context getContextPedidoPdf() {
        List<PedidoResponseDto> pedidoResponseDtos = pedidoService.pedidos();
        Context context = new Context();
        context.setVariable("pedidos", pedidoResponseDtos);
        return context;
    }

    private String loadAndFillTemplate(Context context) {
        return springTemplateEngine.process("index", context);
    }

}
