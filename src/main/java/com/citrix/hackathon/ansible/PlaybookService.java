package com.citrix.hackathon.ansible;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sanketmishra on 9/26/16.
 */

@Service
public class PlaybookService {

    @Value("${playbook.directory.location}")
    private String playbookDirectory;


    @Value("${playbook.log.path}")
    private String playbookLogPath;

    @Value("${playbook.demo.location}")
    private String playbookDemoLocation;

    private String pattern = "([-d])(\\S+)\\s+(\\d+)\\s+(\\w+)\\s+(\\w+)\\s+(\\d+)\\s+(\\w{3}\\s\\d{1,2}\\s+\\d{1,2}:\\d{1,2})\\s(.*)";

    public List<Playbook> getAllPlaybooksFromDirectory(){

        List<Playbook> playbookList = new ArrayList<>();

        String command = "ls -l " + this.playbookDirectory;
        Process process;
        try {
            process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                Pattern r = Pattern.compile(this.pattern);

                Matcher m = r.matcher(line);
                if (m.find( )) {

                    if (m.group(1).equals("d")) {
                        Playbook playbook = new Playbook();
                        playbook.setPlayBookName(m.group(8));
                        playbook.setPlayBookPermission(m.group(2));
                        playbook.setPlayBookOwner(m.group(4));
                        playbook.setPlayBookGroup(m.group(5));
                        playbook.setPlayBookSize(m.group(6));
                        playbook.setPlaybookLstModifiedTime(m.group(7));
                        playbookList.add(playbook);
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return playbookList;
    }


    public String getPlaybookLogs(){

        String allLines = "\r\n";
        try (BufferedReader br = new BufferedReader(new FileReader(this.playbookLogPath)))
        {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
//                System.out.println(sCurrentLine);
                allLines = allLines.concat(sCurrentLine).concat("\r\n");
            }
            return allLines;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    Boolean triggerPlaybook(){

        String[] cmd = { "/bin/sh", "-c", "python runplaybook.py > "+ this.playbookLogPath };

        System.out.println( "Triggering playbook ... " + String.join(" ", cmd));

        try {
            Process p = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;

    }


    private String executeCommand(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }


}
