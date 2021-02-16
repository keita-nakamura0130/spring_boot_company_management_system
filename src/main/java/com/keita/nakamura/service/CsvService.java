package com.keita.nakamura.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.keita.nakamura.entity.Company;

/**
 * CSVサービス
 */
@Service
public class CsvService {
    
    @Autowired
    CompanyService CompanyService;

    /**
     * コンマ
     */
    private static final String COMMA = ",";

    /**
     * 改行
     */
    private static final String NEW_LINE = "\n";

    /**
     * CSVより会社インスタンスを取得
     *
     * @param csv
     * @return
     */
    public List<Company> getCompanyInstancesFromCsv(MultipartFile csv) {
        // 初期化
        List<Company> companies = new ArrayList<>();
        InputStream stream = null;
        Reader reader = null;
        BufferedReader br = null;
        String line = null;

        try {
            stream = csv.getInputStream();
            reader = new InputStreamReader(stream);
            br = new BufferedReader(reader);

            while ((line = br.readLine()) != null) {
                String[] column = line.split(",");

                // [0]会社名, [1]代表者, [2]電話番号, [3]郵便番号, [4]都道府県コード, [5]住所, [6]メールアドレス
                Company company = new Company(column[0], column[1], column[2], column[3], column[4], column[5], column[6]);

                companies.add(company);
            }
            line = br.readLine();

            // ヘッダーを削除
            companies.remove(0);

            br.close();
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("CSVを正しく読み込めませんでした。");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("CSVを正しく読み込めませんでした。");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("CSVを正しく読み込めませんでした。");
            e.printStackTrace();
        } finally {
            try {
                br.close();
                reader.close();
                stream.close();
            } catch (Exception e) {
                System.out.println("CSVを正しく閉じることができませんでした。");
                e.printStackTrace();
            }
        }
        return companies;
    }

    /**
    * CSVエクスポート用のファイルを作成
    */
    public void csvExportCreate() {
        // 初期化
        List<Company> companies = CompanyService.findAll();
        FileWriter fileWriter = null;
        BufferedWriter bf = null;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter("src/main/resources/companies.csv", false);
            bf = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bf);

            // ヘッダー
            printWriter.print("会社名");
            printWriter.print(COMMA);
            printWriter.print("代表者");
            printWriter.print(COMMA);
            printWriter.print("電話番号");
            printWriter.print(COMMA);
            printWriter.print("郵便番号");
            printWriter.print(COMMA);
            printWriter.print("都道府県コード");
            printWriter.print(COMMA);
            printWriter.print("住所");
            printWriter.print(COMMA);
            printWriter.print("メールアドレス");
            printWriter.print(NEW_LINE);

            for (Company company : companies) {
                printWriter.print(company.getName());
                printWriter.print(COMMA);
                printWriter.print(company.getRepresentative());
                printWriter.print(COMMA);
                printWriter.print(company.getPhoneNumber());
                printWriter.print(COMMA);
                printWriter.print(company.getPostalCode());
                printWriter.print(COMMA);
                printWriter.print(company.getPrefectureCode());
                printWriter.print(COMMA);
                printWriter.print(company.getAddress());
                printWriter.print(COMMA);
                printWriter.print(company.getMailAddress());
                printWriter.print(NEW_LINE);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("CSVを正しく読み込めませんでした。");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("CSVを正しく読み込めませんでした。");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("CSVを正しく読み込めませんでした。");
        } finally {
            try {
                printWriter.close();
                bf.close();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("CSVを正しく閉じることができませんでした。");
                e.printStackTrace();
            }
        }
    }

    /**
     * InputStreamからバイト文字列に変換
     *
     * @param resource
     * @return
     */
    public byte[] StreamToByte(Resource resource) {

        int nRead;
        InputStream is = null;
        byte[] fileContent = new byte[16384];
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        // ファイルをバイト形式に変換
        try {
            is = new FileInputStream(resource.getFile().toString());

            while ((nRead = is.read(fileContent, 0, fileContent.length)) != -1) {
                buffer.write(fileContent, 0, nRead);
            }

            buffer.flush();

            return buffer.toByteArray();
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * ダウンロードファイル書き込み
     *
     * @param response
     * @param fileContent
     */
    public void OutputStreamWrite(HttpServletResponse response, byte[] fileContent) {
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            os.write(fileContent);
            os.flush();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
