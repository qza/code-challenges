package codechallenges.java8;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

public class TimeBasics {

	public static void main(String[] args) {

		Instant instantNow = Instant.now();

		log("Instant now: " + instantNow);

		log("Instant MAX/MIN: " + Instant.MAX + " / " + Instant.MIN);

		LocalDate localDateNow = LocalDate.now();

		log("localDateNow: " + localDateNow);

		LocalDateTime localDateTimeNow = LocalDateTime.now();

		log("localDateTimeNow: " + localDateTimeNow);

		LocalDateTime localDateTimeTommorow07Morning = LocalDateTime.now().plusDays(1).with(ChronoField.HOUR_OF_DAY, 7)
				.with(ChronoField.MINUTE_OF_HOUR, 0).with(ChronoField.SECOND_OF_MINUTE, 0)
				.with(ChronoField.MILLI_OF_SECOND, 0);

		log("localDateTimeTommorow07Morning: " + localDateTimeTommorow07Morning);

		Period periodOf2Years = Period.ofYears(1).plus(Period.ofMonths(12)).plus(Period.ofDays(1000));

		log("periodOf2Years: " + periodOf2Years.toTotalMonths());

		Duration durationOfMinute = Duration.ofSeconds(59).plus(Duration.ofMillis(1000));

		log("durationOfMinute: " + durationOfMinute.toMinutes());

		ZoneId thisZone = ZoneId.systemDefault();

		ZoneId someZone = ZoneId.of(ZoneId.getAvailableZoneIds().iterator().next());

		ZonedDateTime thisZoneDateTime = ZonedDateTime.now();

		log("thisZoneDateTime : " + thisZoneDateTime);

		ZonedDateTime someZoneDateTime = ZonedDateTime.now(someZone);

		log("someZoneDateTime : " + someZoneDateTime);

		ZoneOffset localZoneOffset = thisZone.getRules().getOffset(localDateTimeNow);

		log("localZoneOffset" + localZoneOffset);
	}

	private static void log(String what) {
		System.out.println(what);
	}

}
