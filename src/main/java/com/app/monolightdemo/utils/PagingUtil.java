package com.app.monolightdemo.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.app.monolightdemo.dto.LinkDTO;

@Component
public class PagingUtil {

	public List<LinkDTO> createPagingList(String url, Integer page, Integer totalPages) {

		List<LinkDTO> links = new ArrayList<>();

		for (int i = 1; i <= totalPages; i++) {

			if (i == 1) {
				LinkDTO previous = new LinkDTO(page == 1 ? null : (url + "page=" + (page - 1)), "Previous", false);
				links.add(previous);
			}

			LinkDTO link = new LinkDTO(url + "page=" + i, String.valueOf(i),
					(page == i || (page == 1 && i == 1) ? true : false));
			
			links.add(link);

			if (i == totalPages) {
				int nextPage = page + 1;
				String _url = totalPages == 1 || page == totalPages ? null : url + "page=" + nextPage;
				LinkDTO next = new LinkDTO(_url, "Next", false);
				links.add(next);
			}
		}
		return links;

	}
}
