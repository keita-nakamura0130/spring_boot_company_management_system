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
        List<Company> companies = new ArrayList<>();
        String line = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(csv.getInputStream()))) {
            while ((line = br.readLine()) != null) {
                String[] column = line.split(COMMA);

                // [0]会社名, [1]代表者, [2]電話番号, [3]郵便番号, [4]都道府県コード, [5]住所, [6]メールアドレス
                Company company = new Company(column[0], column[1], column[2], column[3], column[4], column[5], column[6]);

                companies.add(company);
            }

            // ヘッダーを削除
            companies.remove(0);

        } catch (FileNotFoundException e) {
            System.out.println("CSVを正しく読み込めませんでした。");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("CSVを正しく読み込めませんでした。");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("CSVを正しく読み込めませんでした。");
            e.printStackTrace();
        }
        return companies;
    }

    /**
    * CSVエクスポート用のファイルを作成
    */
    public void csvFileCreate() {
        List<Company> companies = CompanyService.findAll();

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/main/resources/companies.csv", false)))) {

            // ヘッダー
            pw.print("会社名");
            pw.print(COMMA);
            pw.print("代表者");
            pw.print(COMMA);
            pw.print("電話番号");
            pw.print(COMMA);
            pw.print("郵便番号");
            pw.print(COMMA);
            pw.print("都道府県コード");
            pw.print(COMMA);
            pw.print("住所");
            pw.print(COMMA);
            pw.print("メールアドレス");
            pw.print(NEW_LINE);

            for (Company company : companies) {
                pw.print(company.getName());
                pw.print(COMMA);
                pw.print(company.getRepresentative());
                pw.print(COMMA);
                pw.print(company.getPhoneNumber());
                pw.print(COMMA);
                pw.print(company.getPostalCode());
                pw.print(COMMA);
                pw.print(company.getPrefectureCode());
                pw.print(COMMA);
                pw.print(company.getAddress());
                pw.print(COMMA);
                pw.print(company.getMailAddress());
                pw.print(NEW_LINE);
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
        byte[] fileContent = new byte[16384];
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        // ファイルをバイト形式に変換
        try (InputStream is = new FileInputStream(resource.getFile().toString())) {
            while ((nRead = is.read(fileContent, 0, fileContent.length)) != -1) {
                buffer.write(fileContent, 0, nRead);
            }
            buffer.flush();

            return buffer.toByteArray();
        } catch (FileNotFoundException e) {
            e.getStackTrace();
            System.out.println("バイナリデータに正しく変換できませんでした。");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("バイナリデータに正しく変換できませんでした。");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("バイナリデータに正しく変換できませんでした。");
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
