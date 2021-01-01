#include <windows.h>
#include <gdiplus.h>
#include <tchar.h>
#include "resource.h"
#pragma comment(lib, "Gdiplus.lib")

/* ���� ���⸦ ���� ���� */
#define WM_ASYNC WM_USER+2

/* ���� ���� */
#define SERVER_IP "25.53.17.162"
#define SERVER_PORT 20

using namespace Gdiplus;

LRESULT CALLBACK WndProc(HWND, UINT, WPARAM, LPARAM);
HINSTANCE g_hInst;
HWND hWndMain;
LPCTSTR lpszClass = TEXT("���� ������ �ùķ��̼�");
ULONG_PTR gdiplusToken;
GdiplusStartupInput gdiplusStartupInput;

int APIENTRY WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpszCmdParam, int nCmdShow)
{
    HWND hWnd;
    MSG Message;
    WNDCLASS WndClass;

    g_hInst = hInstance;

    WndClass.cbClsExtra = 0;
    WndClass.cbWndExtra = 0;
    WndClass.hbrBackground = (HBRUSH)GetStockObject(DKGRAY_BRUSH);
    WndClass.hCursor = LoadCursor(NULL, IDC_ARROW);
    WndClass.hIcon = LoadIcon(NULL, IDI_APPLICATION);
    WndClass.hInstance = hInstance;
    WndClass.lpfnWndProc = WndProc;
    WndClass.lpszClassName = lpszClass;
    WndClass.lpszMenuName = MAKEINTRESOURCE(IDR_MENU1);
    WndClass.style = CS_HREDRAW | CS_VREDRAW;
    RegisterClass(&WndClass);
    hWnd = CreateWindow(lpszClass, lpszClass, WS_POPUP, CW_USEDEFAULT, CW_USEDEFAULT, GetSystemMetrics(SM_CXSCREEN), GetSystemMetrics(SM_CXSCREEN), NULL, (HMENU)NULL, hInstance, NULL);
    GdiplusStartup(&gdiplusToken, &gdiplusStartupInput, NULL);
    ShowWindow(hWnd, nCmdShow);

    while (GetMessage(&Message, NULL, 0, 0)) {
        TranslateMessage(&Message);
        DispatchMessage(&Message);
    }
    return (int)Message.wParam;
}
/* ���� ������ ���� ������ ���� */
struct PARKING_SPACE_INFO {
    int pos;
    bool pos_status[10];

}posit = { 0,{false,} };

LRESULT CALLBACK WndProc(HWND hWnd, UINT iMessage, WPARAM wParam, LPARAM lParam)
{
    HDC hdc;
    PAINTSTRUCT ps;

    /* UI ���� ���� ���� */
    RECT r;
    HPEN MyPen, OldPen;
    HBRUSH MyBrush, OldBrush;
    HFONT hFont, oldFont;
    Image* car_1 = Image::FromFile(L"car.png"); //ȸ��
    Image* car_2 = Image::FromFile(L"car1.png"); //���
    TCHAR str[128];
    ::Graphics g(GetDC(hWnd));
    TCHAR ch[2];

    /* ���� ���� ���� */
    static WSADATA wsadata;
    static SOCKET s;
    static SOCKADDR_IN addr = { 0 };
    static TCHAR msg[200];

    static char buffer[100];
    static int count;
    int msgLen;

    switch (iMessage) {
    case WM_CREATE:
        hWndMain = hWnd;

        /* ���� ���� */
        WSAStartup(MAKEWORD(2, 2), &wsadata);
        s = socket(AF_INET, SOCK_STREAM, 0);
        addr.sin_family = AF_INET;
        addr.sin_port = SERVER_PORT;
        addr.sin_addr.s_addr = inet_addr(SERVER_IP);
        WSAAsyncSelect(s, hWnd, WM_ASYNC, FD_READ);

        /* ���� ���� */
        if (connect(s, (LPSOCKADDR)&addr, sizeof(addr)) == -1) {
            return 0;
        }
        return 0;
    case WM_ASYNC:
        switch (lParam)
        {
            /* �����κ��� ���������� �޾ƿ� */
        case FD_READ:
            msgLen = recv(s, buffer, 100, 0);
            buffer[msgLen] = NULL;
#ifdef _UNICODE
            msgLen = MultiByteToWideChar(CP_ACP, 0, buffer, strlen(buffer), NULL, NULL);
            MultiByteToWideChar(CP_ACP, 0, buffer, strlen(buffer), msg, msgLen);
            msg[msgLen] = NULL;
#else
            strcpy_s(msg, buffer);
#endif
            count = _ttoi(msg);
            posit.pos_status[count] = true;
            InvalidateRgn(hWnd, NULL, TRUE);
            break;
        default:
            break;
        }
        return 0;

        /* UI ���� �� ������ �ڵ��� �������� ���� */
    case WM_KEYDOWN:
        switch (wParam)
        {
        case VK_ESCAPE:
            if (MessageBox(hWnd, TEXT("���� �Ͻðڽ��ϱ�?"), TEXT("���� �Ͻðڽ��ϱ�?"), MB_YESNO) == IDYES) {
                PostQuitMessage(0);
            }
            break;
        case VK_RIGHT:
            if (posit.pos + 1 != 10) posit.pos += 1;
            break;
        case VK_LEFT:
            if (posit.pos - 1 != -1) posit.pos -= 1;
            break;
        case VK_UP:
            if (posit.pos - 5 > -1) posit.pos -= 5;
            break;
        case VK_DOWN:
            if (posit.pos + 5 < 10) posit.pos += 5;
            break;
        case VK_RETURN:
            if (posit.pos_status[posit.pos]) {
                MessageBox(hWnd, TEXT("Error"), TEXT("�̹� ���� ���Դϴ�."), MB_ICONWARNING);
                break;
            }
            MessageBox(hWnd, TEXT("�����Ϸ�"), TEXT("���� �Ϸ�"), MB_OK);
            wsprintf(ch, TEXT("%d"), posit.pos);

            /* ������ ���� ���� ���� ���� */
            send(s, (char*)ch, 2, 0);
            posit.pos_status[posit.pos] = true;
            posit.pos = 0;
            break;
        case VK_SPACE:
            if (posit.pos_status[posit.pos]) {
                wsprintf(ch, TEXT("%d"), posit.pos);

                /* ������ ���� ���� ���� ���� */
                send(s, (char*)ch, 2, 0);
                posit.pos_status[posit.pos] = false;
                MessageBox(hWnd, TEXT("�ڸ��� �������ϴ�."), TEXT("�ڸ��� �������ϴ�."), MB_OK);
            }
            break;
        }

        InvalidateRect(hWnd, NULL, FALSE);
        return 0;
    case WM_COMMAND:
        switch (LOWORD(wParam))
        {
        case ID_EXIT:
            if (MessageBox(hWnd, TEXT("���� �Ͻðڽ��ϱ�?"), TEXT("���� �Ͻðڽ��ϱ�?"), MB_YESNO) == IDYES) {
                PostQuitMessage(0);
                break;
            }
            break;
        }
    case WM_PAINT:
    {
        /* UI ���� */
        hdc = BeginPaint(hWnd, &ps);
        GetClientRect(hWnd, &r);
        MyPen = CreatePen(PS_SOLID, 3, RGB(255, 255, 255));
        OldPen = (HPEN)SelectObject(hdc, MyPen);
        MyBrush = CreateSolidBrush(RGB(128, 128, 128));
        OldBrush = (HBRUSH)SelectObject(hdc, MyBrush);

        /* Ÿ��Ʋ */

        SetBkColor(hdc, RGB(64, 64, 64));
        SetTextColor(hdc, RGB(0, 0, 0));
        hFont = CreateFont(24, 0, 0, 0, 0, 0, 0, 0, HANGEUL_CHARSET, 0, 0, 0, VARIABLE_PITCH | FF_ROMAN, TEXT("�޸յձ�������"));
        oldFont = (HFONT)SelectObject(hdc, hFont);
        TextOut(hdc, r.right / 2.7, r.bottom / 4, TEXT("���� ������ �ùķ��̼�  v1.0.0"), 20);
        SelectObject(hdc, oldFont);
        DeleteObject(hFont);

        /* UI �� Text Bk ���� ���� */
        SetBkColor(hdc, RGB(128, 128, 128));
        SetTextColor(hdc, RGB(88, 88, 88));

        /* 0 ~ 9 �� �ڵ��� ���� ���� */
        for (int i = 1; i <= 10; i++) {
            if (1 <= i && i <= 5) {
                if ((i - 1) == posit.pos || posit.pos_status[i - 1] == true) {
                    MyPen = CreatePen(PS_SOLID, 3, RGB(128, 128, 128));
                    OldPen = (HPEN)SelectObject(hdc, MyPen);
                    MyBrush = CreateHatchBrush(HS_BDIAGONAL, RGB(0, 0, 0));
                    OldBrush = (HBRUSH)SelectObject(hdc, MyBrush);
                    Rectangle(hdc, (r.right / 50) + r.right / 5 + ((i - 1) * (r.right / 10)), r.bottom / 50, (r.right / 10) * i + r.right / 5, r.bottom / 6.5);
                    SelectObject(hdc, OldBrush);
                    DeleteObject(MyBrush);
                    SelectObject(hdc, OldPen);
                    DeleteObject(MyPen);

                    if ((i - 1) == posit.pos) {
                        MyPen = CreatePen(PS_SOLID, 3, RGB(255, 0, 0));
                        OldPen = (HPEN)SelectObject(hdc, MyPen);
                        Rectangle(hdc, (r.right / 50) + r.right / 5 + ((i - 1) * (r.right / 10)), r.bottom / 50, (r.right / 10) * i + r.right / 5, r.bottom / 6.5);

                        SelectObject(hdc, OldPen);
                        DeleteObject(MyPen);
                    }
                    g.DrawImage(car_1, (int)(r.right / 50) + (int)r.right / 5.65 + ((int)(i - 1) * (int)(r.right / 10)), (int)r.bottom / 50, (int)r.right / 8, (int)r.bottom / 8);

                }
                else {
                    Rectangle(hdc, (r.right / 50) + r.right / 5 + ((i - 1) * (r.right / 10)), r.bottom / 50, (r.right / 10) * i + r.right / 5, r.bottom / 6.5);
                    hFont = CreateFont(60, 0, 0, 0, 0, 0, 0, 0, HANGEUL_CHARSET, 0, 0, 0, VARIABLE_PITCH | FF_ROMAN, TEXT("�޸յձ�������"));
                    oldFont = (HFONT)SelectObject(hdc, hFont);
                    wsprintf(str, TEXT("%d"), i - 1);
                    TextOut(hdc, ((r.right / 50) + r.right / 4.37 + ((i - 1) * (r.right / 10))), r.bottom / 17, str, lstrlen(str));
                    SelectObject(hdc, oldFont);
                    DeleteObject(hFont);
                }
            }
            else {
                if ((i - 1) == posit.pos || posit.pos_status[i - 1] == true) {
                    MyPen = CreatePen(PS_SOLID, 3, RGB(128, 128, 128));
                    OldPen = (HPEN)SelectObject(hdc, MyPen);
                    MyBrush = CreateHatchBrush(HS_BDIAGONAL, RGB(0, 0, 0));
                    OldBrush = (HBRUSH)SelectObject(hdc, MyBrush);
                    Rectangle(hdc, (r.right / 50) + r.right / 5 + (((i - 6)) * (r.right / 10)), r.bottom / 2.75, (r.right / 10) * (i - 5) + r.right / 5, r.bottom / 2);
                    SelectObject(hdc, OldBrush);
                    DeleteObject(MyBrush);
                    SelectObject(hdc, OldPen);
                    DeleteObject(MyPen);
                    if ((i - 1) == posit.pos) {
                        MyPen = CreatePen(PS_SOLID, 3, RGB(255, 0, 0));
                        OldPen = (HPEN)SelectObject(hdc, MyPen);
                        Rectangle(hdc, (r.right / 50) + r.right / 5 + (((i - 6)) * (r.right / 10)), r.bottom / 2.75, (r.right / 10) * (i - 5) + r.right / 5, r.bottom / 2);

                        SelectObject(hdc, OldPen);
                        DeleteObject(MyPen);
                    }
                    g.DrawImage(car_2, (int)(r.right / 50) + (int)r.right / 5.65 + ((int)((i - 6)) * (int)(r.right / 10)), (int)r.bottom / 2.66, (int)r.right / 8, (int)r.bottom / 8);
                }
                else {
                    Rectangle(hdc, (r.right / 50) + r.right / 5 + (((i - 6)) * (r.right / 10)), r.bottom / 2.75, (r.right / 10) * (i - 5) + r.right / 5, r.bottom / 2);
                    hFont = CreateFont(60, 0, 0, 0, 0, 0, 0, 0, HANGEUL_CHARSET, 0, 0, 0, VARIABLE_PITCH | FF_ROMAN, TEXT("�޸յձ�������"));
                    oldFont = (HFONT)SelectObject(hdc, hFont);
                    wsprintf(str, TEXT("%d"), i - 1);
                    TextOut(hdc, ((r.right / 50) + r.right / 4.4 + (((i - 6)) * (r.right / 10))), r.bottom / 2.45, str, lstrlen(str));
                    SelectObject(hdc, oldFont);
                    DeleteObject(hFont);
                }
            }
        }

        SelectObject(hdc, OldBrush);
        SelectObject(hdc, OldPen);
        DeleteObject(MyBrush);
        DeleteObject(MyPen);

        EndPaint(hWnd, &ps);
        return 0;
    }

    case WM_DESTROY:
        closesocket(s);
        WSACleanup();
        delete car_1;
        delete car_2;
        PostQuitMessage(0);
        return 0;
    }
    return(DefWindowProc(hWnd, iMessage, wParam, lParam));
}