<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Voucher Page</title>
        <style>
            .voucher-container {
                display: flex;
                flex-wrap: wrap;
                gap: 20px;
                padding: 20px;
            }
            .voucher-card {
                border: 1px solid #ccc;
                border-radius: 8px;
                width: 250px;
                padding: 16px;
                box-shadow: 0 2px 6px rgba(0,0,0,0.1);
                position: relative;
                background-color: #f9f9f9;
            }
            .voucher-code {
                font-size: 20px;
                font-weight: bold;
                margin-bottom: 8px;
            }
            .voucher-desc {
                font-size: 14px;
                margin-bottom: 8px;
            }
            .voucher-percent {
                color: green;
                font-weight: bold;
                margin-bottom: 12px;
            }
            .copy-btn {
                position: absolute;
                top: 10px;
                right: 10px;
                cursor: pointer;
                background: none;
                border: none;
                font-size: 16px;
            }
            .copy-success {
                color: green;
                font-size: 12px;
                margin-top: 5px;
            }
        </style>
        <script>
            function copyToClipboard(code, btn) {
                navigator.clipboard.writeText(code).then(function () {
                    // Show success text
                    const success = document.createElement('div');
                    success.className = 'copy-success';
                    success.innerText = 'Đã sao chép!';
                    btn.parentElement.appendChild(success);
                    setTimeout(() => success.remove(), 1500);
                });
            }
        </script>
    </head>
    <body>
        <h2 style="text-align:center;">Danh sách Voucher</h2>
        <div class="voucher-container">
            <c:forEach var="discount" items="${voucherList}">
                <div class="voucher-card">
                    <button class="copy-btn" onclick="copyToClipboard('${discount.getCode()}', this)">📋</button>
                    <div class="voucher-code">${discount.getCode()}</div>
                    <div class="voucher-desc">${discount.getDescription()}</div>
                    <div class="voucher-percent">Giảm ${discount.getDiscount_percent()}%</div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
