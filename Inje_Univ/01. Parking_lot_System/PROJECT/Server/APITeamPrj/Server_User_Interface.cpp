#include <windows.h>
#include <iostream>
#include <fstream>
#include <string>
#include<stdio.h>
#include "resource.h"
#define WM_ASYNC WM_USER+2
using namespace std;

void modifyParked(int parked_num);
boolean retParked(int num);
LRESULT CALLBACK WndProc(HWND, UINT, WPARAM, LPARAM);
HINSTANCE g_hInst;
HWND hWndMain;
LPCTSTR lpszClass = TEXT("Parking lot Server Screen");
ofstream fout("log.txt", ios_base::out);
ifstream fin("log.txt");
int cnt;

int APIENTRY WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance
	, LPSTR lpszCmdParam, int nCmdShow)
{
	fout << "==================== Parking Spot I/O log ====================\n" << endl;
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

	hWnd = CreateWindow(
		lpszClass,
		lpszClass,
		WS_POPUP,
		CW_USEDEFAULT,
		CW_USEDEFAULT,
		GetSystemMetrics(SM_CXSCREEN),   // 전체화면 Width
		GetSystemMetrics(SM_CXSCREEN),   // 전체화면 Height
		NULL,
		(HMENU)NULL,
		hInstance, NULL);
	ShowWindow(hWnd, nCmdShow);

	while (GetMessage(&Message, NULL, 0, 0)) {
		TranslateMessage(&Message);
		DispatchMessage(&Message);
	}

	return (int)Message.wParam;
}

struct parkingSeat {
	int num;         // 주차공간 번호
	boolean isParked;   // true = 이미 주차됨 , false = 비어있음
}park[10] = {
   {1,      false},
   {2,      false},
   {3,      false},
   {4,      false},
   {5,      false},
   {6,      false},
   {7,      false},
   {8,      false},
   {9,      false},
   {10,     false},
};

// 정보를 받음 -> true 

boolean first = true;
int amount;
boolean isOutModify;
boolean isInModify;
int modifyNum;

TCHAR str[5];
TCHAR rslt[50] = TEXT("");

HANDLE hMutex;
DWORD WINAPI ThreadFunc(LPVOID prc)
{
	WaitForSingleObject(hMutex, INFINITE);
	Sleep(1);

	HDC hdc;
	RECT r;
	HPEN MyPen, OldPen;
	HBRUSH MyBrush, OldBrush;

	HFONT hFont, oldFont;

	hdc = GetDC(hWndMain);
	GetClientRect(hWndMain, &r);
	//SetBkMode(hdc, TRANSPARENT);

	//InvalidateRect(hWndMain, NULL, TRUE);

	MyPen = CreatePen(PS_SOLID, 6, RGB(255, 255, 255));
	OldPen = (HPEN)SelectObject(hdc, MyPen);
	MyBrush = CreateSolidBrush(RGB(68, 189, 50));
	OldBrush = (HBRUSH)SelectObject(hdc, MyBrush);

	SetTextColor(hdc, RGB(33, 140, 134));
	SetBkColor(hdc, RGB(68, 189, 50));
	if (isOutModify) {
		int i = modifyNum;

		amount--;
		if (i < 5) {
			Rectangle(hdc, (r.right / 50) + r.right / 5 + (i * (r.right / 10)), r.bottom / 50, (r.right / 10) * (i + 1) + r.right / 5, r.bottom / 6.5);

			hFont = CreateFont(60, 0, 0, 0, 0, 0, 0, 0, HANGEUL_CHARSET, 0, 0, 0, VARIABLE_PITCH | FF_ROMAN, TEXT("휴먼둥근헤드라인"));
			oldFont = (HFONT)SelectObject(hdc, hFont);
			wsprintf(str, TEXT("%d"), i);
			TextOut(hdc, ((r.right / 50) + r.right / 4.37 + (i * (r.right / 10))), r.bottom / 17, str, 1);
			SelectObject(hdc, oldFont);
			DeleteObject(hFont);
		}
		else {
			Rectangle(hdc, (r.right / 50) + r.right / 5 + ((i % 5) * (r.right / 10)), r.bottom / 2.75, (r.right / 10) * ((i % 5) + 1) + r.right / 5, r.bottom / 2);

			hFont = CreateFont(60, 0, 0, 0, 0, 0, 0, 0, HANGEUL_CHARSET, 0, 0, 0, VARIABLE_PITCH | FF_ROMAN, TEXT("휴먼둥근헤드라인"));
			oldFont = (HFONT)SelectObject(hdc, hFont);
			wsprintf(str, TEXT("%d"), i);
			TextOut(hdc, ((r.right / 50) + r.right / 4.4 + ((i % 5) * (r.right / 10))), r.bottom / 2.45, str, lstrlen(str));
			SelectObject(hdc, oldFont);
			DeleteObject(hFont);
		}
	}

	if (isInModify) {
		int i = modifyNum;

		MyBrush = CreateSolidBrush(RGB(194, 54, 22));
		OldBrush = (HBRUSH)SelectObject(hdc, MyBrush);

		SetTextColor(hdc, RGB(255, 121, 63));
		SetBkColor(hdc, RGB(194, 54, 22));
		if (i < 5) {
			amount++;

			Rectangle(hdc, (r.right / 50) + r.right / 5 + (i * (r.right / 10)), r.bottom / 50, (r.right / 10) * (i + 1) + r.right / 5, r.bottom / 6.5);

			hFont = CreateFont(60, 0, 0, 0, 0, 0, 0, 0, HANGEUL_CHARSET, 0, 0, 0, VARIABLE_PITCH | FF_ROMAN, TEXT("휴먼둥근헤드라인"));
			oldFont = (HFONT)SelectObject(hdc, hFont);
			wsprintf(str, TEXT("%d"), i);
			TextOut(hdc, ((r.right / 50) + r.right / 4.37 + (i * (r.right / 10))), r.bottom / 17, str, 1);
			SelectObject(hdc, oldFont);
			DeleteObject(hFont);
		}
		else {
			amount++;

			Rectangle(hdc, (r.right / 50) + r.right / 5 + ((i % 5) * (r.right / 10)), r.bottom / 2.75, (r.right / 10) * ((i % 5) + 1) + r.right / 5, r.bottom / 2);

			hFont = CreateFont(60, 0, 0, 0, 0, 0, 0, 0, HANGEUL_CHARSET, 0, 0, 0, VARIABLE_PITCH | FF_ROMAN, TEXT("휴먼둥근헤드라인"));
			oldFont = (HFONT)SelectObject(hdc, hFont);
			wsprintf(str, TEXT("%d"), i);
			TextOut(hdc, ((r.right / 50) + r.right / 4.4 + ((i % 5) * (r.right / 10))), r.bottom / 2.45, str, lstrlen(str));
			SelectObject(hdc, oldFont);
			DeleteObject(hFont);
		}
	}

	SetTextColor(hdc, RGB(255, 255, 255));
	SetBkColor(hdc, RGB(194, 54, 22));
	hFont = CreateFont(20, 0, 0, 0, 0, 0, 0, 0, HANGEUL_CHARSET, 0, 0, 0, VARIABLE_PITCH | FF_ROMAN, TEXT("휴먼둥근헤드라인"));
	oldFont = (HFONT)SelectObject(hdc, hFont);

	amount > 0 ? wsprintf(rslt, TEXT(" 주차 가능 공간 : %c%d "), '0', 10 - amount) : wsprintf(rslt, TEXT(" 주차 가능 공간 : %d "), 10 - amount);

	TextOut(hdc, r.right / 1.2, r.bottom / 2, rslt, lstrlen(rslt));

	SelectObject(hdc, oldFont);
	DeleteObject(hFont);

	SelectObject(hdc, OldBrush);
	SelectObject(hdc, OldPen);
	DeleteObject(MyBrush);
	DeleteObject(MyPen);

	isOutModify = false;
	isInModify = false;

	ReleaseMutex(hMutex);

	ReleaseDC(hWndMain, hdc);
	return 0;
}

DWORD ThreadID;
HANDLE hThread;

LRESULT CALLBACK WndProc(HWND hWnd, UINT iMessage, WPARAM wParam, LPARAM lParam)
{
	HDC hdc, MemDC;
	PAINTSTRUCT ps;
	RECT r;
	HPEN MyPen, OldPen;
	HBRUSH MyBrush, OldBrush;

	static WSADATA wsadata;
	static SOCKET s, cs;
	static TCHAR msg[200];
	static SOCKADDR_IN addr = { 0 }, c_addr;
	int size, msgLen;
	char buffer[100];

	TCHAR str[1024];
	HFONT hFont, oldFont;
	TCHAR ch[2];
	int car;

	switch (iMessage) {
	case WM_CREATE:

		CloseHandle(CreateThread(NULL, 0, ThreadFunc, NULL, 0, &ThreadID));
		//InitializeCriticalSection(&crit);
		hMutex = CreateMutex(NULL, FALSE, NULL);
		hWndMain = hWnd;

		WSAStartup(MAKEWORD(2, 2), &wsadata);
		s = socket(AF_INET, SOCK_STREAM, 0);
		addr.sin_family = AF_INET;
		addr.sin_port = 20;
		addr.sin_addr.s_addr = inet_addr("25.53.17.162");
		bind(s, (LPSOCKADDR)&addr, sizeof(addr));
		WSAAsyncSelect(s, hWnd, WM_ASYNC, FD_ACCEPT);
		if (listen(s, 5) == -1)
			return 0;

		return 0;
	case WM_ASYNC:
		switch (lParam)
		{
		case FD_ACCEPT:
			size = sizeof(c_addr);
			cs = accept(s, (LPSOCKADDR)&c_addr, &size);
			for (int i = 0; i < 10; i++) {
				Sleep(50);
				if (!retParked(i))
				{
					wsprintf(ch, TEXT("%d"), i);
					send(cs, (char*)ch, 2, 0);
				}
			}

			WSAAsyncSelect(cs, hWnd, WM_ASYNC, FD_READ);
			break;
		case FD_READ:
			msgLen = recv(cs, buffer, 100, 0);
			buffer[msgLen] = NULL;

#ifdef _UNICODE
			msgLen = MultiByteToWideChar(CP_ACP, 0, buffer, strlen(buffer), NULL, NULL);
			MultiByteToWideChar(CP_ACP, 0, buffer, strlen(buffer), msg, msgLen);
			msg[msgLen] = NULL;
#else
			strcpy_s(msg, buffer);
#endif
			car = stoi(msg);

			modifyParked(car);
			InvalidateRgn(hWnd, NULL, FALSE);
			break;
		default:
			break;
		}
		return 0;
	case WM_KEYDOWN:
		switch (wParam)
		{
		case VK_ESCAPE:
			if (MessageBox(hWnd, TEXT("종료하시겠습니까?"), TEXT("Info"),
				MB_YESNO) == IDYES) {
				PostQuitMessage(0);
				break;
			}
			break;
		}
		return 0;
	case WM_COMMAND:
		switch (LOWORD(wParam)) {
		case ID_EXIT:
			if (MessageBox(hWnd, TEXT("종료하시겠습니까?"), TEXT("Info"),
				MB_YESNO) == IDYES) {
				PostQuitMessage(0);
				break;
			}
			break;
		}
		return 0;
	case WM_PAINT:
		hdc = BeginPaint(hWnd, &ps);
		GetClientRect(hWnd, &r);
		MyPen = CreatePen(PS_SOLID, 6, RGB(255, 255, 255));
		OldPen = (HPEN)SelectObject(hdc, MyPen);
		SetBkMode(hdc, TRANSPARENT);

		SetTextColor(hdc, RGB(33, 140, 134));

		/*******************************
		*        주차장 Shape         *
		********************************/
		for (int i = 1; i <= 5; i++) {
			if (park[i - 1].isParked) {
				MyBrush = CreateSolidBrush(RGB(194, 54, 22));
				OldBrush = (HBRUSH)SelectObject(hdc, MyBrush);

				SetTextColor(hdc, RGB(255, 121, 63));
				SetBkColor(hdc, RGB(194, 54, 22));
			}
			else {
				MyBrush = CreateSolidBrush(RGB(68, 189, 50));
				OldBrush = (HBRUSH)SelectObject(hdc, MyBrush);

				SetTextColor(hdc, RGB(33, 140, 134));
				SetBkColor(hdc, RGB(68, 189, 50));
			}

			Rectangle(hdc, (r.right / 50) + r.right / 5 + ((i - 1) * (r.right / 10)), r.bottom / 50, (r.right / 10) * i + r.right / 5, r.bottom / 6.5);

			hFont = CreateFont(60, 0, 0, 0, 0, 0, 0, 0, HANGEUL_CHARSET, 0, 0, 0, VARIABLE_PITCH | FF_ROMAN, TEXT("휴먼둥근헤드라인"));
			oldFont = (HFONT)SelectObject(hdc, hFont);
			wsprintf(str, TEXT("%d"), i - 1);
			TextOut(hdc, ((r.right / 50) + r.right / 4.37 + ((i - 1) * (r.right / 10))), r.bottom / 17, str, 1);
			SelectObject(hdc, oldFont);
			DeleteObject(hFont);
			SelectObject(hdc, OldBrush);
			DeleteObject(MyBrush);
		}
		for (int i = 1; i <= 5; i++) {
			if (park[4 + i].isParked) {
				MyBrush = CreateSolidBrush(RGB(194, 54, 22));
				OldBrush = (HBRUSH)SelectObject(hdc, MyBrush);

				SetTextColor(hdc, RGB(255, 121, 63));
				SetBkColor(hdc, RGB(194, 54, 22));
			}
			else {
				MyBrush = CreateSolidBrush(RGB(68, 189, 50));
				OldBrush = (HBRUSH)SelectObject(hdc, MyBrush);

				SetTextColor(hdc, RGB(33, 140, 134));
				SetBkColor(hdc, RGB(68, 189, 50));
			}

			Rectangle(hdc, (r.right / 50) + r.right / 5 + ((i - 1) * (r.right / 10)), r.bottom / 2.75, (r.right / 10) * i + r.right / 5, r.bottom / 2);

			//Rectangle(hdc, (r.right / 50) + r.right / 5 + ((i - 1) * (r.right / 10)), r.bottom / 2.75, (r.right / 10) * i + r.right / 5, r.bottom / 2);
			hFont = CreateFont(60, 0, 0, 0, 0, 0, 0, 0, HANGEUL_CHARSET, 0, 0, 0, VARIABLE_PITCH | FF_ROMAN, TEXT("휴먼둥근헤드라인"));
			oldFont = (HFONT)SelectObject(hdc, hFont);
			wsprintf(str, TEXT("%d"), 4 + i);
			TextOut(hdc, ((r.right / 50) + r.right / 4.4 + ((i - 1) * (r.right / 10))), r.bottom / 2.45, str, lstrlen(str));
			SelectObject(hdc, oldFont);
			DeleteObject(hFont);
			SelectObject(hdc, OldBrush);
			DeleteObject(MyBrush);
		}

		SetTextColor(hdc, RGB(255, 255, 255));
		SetBkColor(hdc, RGB(194, 54, 22));
		hFont = CreateFont(20, 0, 0, 0, 0, 0, 0, 0, HANGEUL_CHARSET, 0, 0, 0, VARIABLE_PITCH | FF_ROMAN, TEXT("휴먼둥근헤드라인"));
		oldFont = (HFONT)SelectObject(hdc, hFont);

		amount > 0 ? wsprintf(rslt, TEXT(" 주차 가능 공간 : %c%d "), '0', 10 - amount) : wsprintf(rslt, TEXT(" 주차 가능 공간 : %d "), 10 - amount);

		TextOut(hdc, r.right / 1.2, r.bottom / 2, rslt, lstrlen(rslt));

		SelectObject(hdc, oldFont);
		DeleteObject(hFont);

		SelectObject(hdc, OldBrush);
		DeleteObject(MyBrush);
		SelectObject(hdc, OldPen);
		DeleteObject(MyPen);

		SetBkColor(hdc, RGB(64, 64, 64));
		SetTextColor(hdc, RGB(0, 0, 0));
		hFont = CreateFont(24, 0, 0, 0, 0, 0, 0, 0, HANGEUL_CHARSET, 0, 0, 0, VARIABLE_PITCH | FF_ROMAN, TEXT("휴먼둥근헤드라인"));
		oldFont = (HFONT)SelectObject(hdc, hFont);
		TextOut(hdc, r.right / 2.7, r.bottom / 4, TEXT("Parking lot Server Screen"), 25);
		SelectObject(hdc, oldFont);
		DeleteObject(hFont);

		EndPaint(hWnd, &ps);
		return 0;
	case WM_DESTROY:
		closesocket(s);
		WSACleanup();
		fout.close();
		PostQuitMessage(0);
		return 0;

	}
	return(DefWindowProc(hWnd, iMessage, wParam, lParam));
}

void modifyParked(int parked_num) {         // 해당 칸 상태 변환
	int num = park[parked_num].num;
	modifyNum = parked_num;
	cnt++;

	if (parked_num > -1) park[parked_num].isParked = !park[parked_num].isParked;

	if (park[parked_num].isParked) isInModify = true;
	else isOutModify = true;

	if (park[parked_num].isParked)
		fout << to_string(num - 1) + "번 자리 입고됨" << endl;
	else
		fout << to_string(num - 1) + "번 자리 출고됨" << endl;
	if (cnt % 5 == 0)
		fout << endl;

	CloseHandle(CreateThread(NULL, 0, ThreadFunc, NULL, 0, &ThreadID));
}

boolean retParked(int num) {
	if (park[num].isParked)
		return false;         // 주차되어 있으면, false 반환
	return true;            // 빈 자리일 경우, true 반환
}