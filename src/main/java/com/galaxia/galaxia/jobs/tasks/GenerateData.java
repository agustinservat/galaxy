package com.galaxia.galaxia.jobs.tasks;

import com.galaxia.galaxia.models.SolarSystem;
import com.galaxia.galaxia.models.Weather;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.time.LocalDate;
import java.util.HashMap;

public class GenerateData implements Tasklet {

    private static final SolarSystem solarSystem = new SolarSystem();

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception
    {
        System.out.println("GenerateData start..");

        LocalDate start = LocalDate.now();
        LocalDate end = LocalDate.now().plusYears(10);
		LocalDate currentStart=LocalDate.from(start);
		LocalDate currentEnd=LocalDate.from(end.plusDays(1));//end is inclusive
        HashMap<String, Integer> program = new HashMap<String, Integer>();
		Integer count = 0;
        do{
			count += 1;
			Weather weather = solarSystem.getWeather(count);
            int repeat = program.containsKey(weather.getStatus()) ? program.get(weather.getStatus()) : 0;
            program.put(weather.getStatus(), repeat + 1);

			currentStart=currentStart.plusDays(1);
		}while (!currentStart.equals(currentEnd));

        program.put("Último pico máximo de lluvia se dio en el día", SolarSystem.getPerimeter());
        program.forEach((k,v) -> System.out.println("Estado: " + k + ": Resultado: " + v));

        System.out.println("GenerateData done..");
        return RepeatStatus.FINISHED;
    }


}
