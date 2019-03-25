package ch29.j;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;


//@Configuration : 스르핑 IoC 컨테이너에게 이 클래스를 직접 알려주기 때문에 이 애노테이션은 필요없다.
@ComponentScan(
		basePackages={"ch29.j2","ch29.j"},
		excludeFilters= {
		@ComponentScan.Filter(
				type=FilterType.REGEX,
				pattern="ch29.j.car"
				),
		@ComponentScan.Filter(
				type=FilterType.REGEX,
				pattern="ch29.j.AppConfig2"
				)}
		)


		public class AppConfig3 {

		}
