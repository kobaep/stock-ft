package com.psa.web;
import com.psa.database.Stockdata;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Stockdata.class)
@Controller
@RequestMapping("/stockdatas")
@RooWebScaffold(path = "stockdatas", formBackingObject = Stockdata.class)
public class StockdataController {
}
