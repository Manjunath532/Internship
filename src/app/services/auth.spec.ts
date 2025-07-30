import { TestBed } from '@angular/core/testing';
import { AuthService } from './auth.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

describe('AuthService', () => {
  let service: AuthService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [AuthService]
    });

    service = TestBed.inject(AuthService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should send signup request and return success message', () => {
    const dummyResponse = 'Signup successful';
    const mockUser = {
      fullName: 'Test User',
      email: 'test@example.com',
      password: 'test123'
    };

    service.signup(mockUser).subscribe((res) => {
      expect(res).toBe(dummyResponse);
    });

    const req = httpMock.expectOne('http://localhost:8080/api/auth/signup');
    expect(req.request.method).toBe('POST');
    req.flush(dummyResponse);
  });

  it('should send login request and return success message', () => {
    const dummyResponse = 'Login successful';
    const email = 'test@example.com';
    const password = 'test123';

    service.login(email, password).subscribe((res) => {
      expect(res).toBe(dummyResponse);
    });

    const req = httpMock.expectOne('http://localhost:8080/api/auth/login');
    expect(req.request.method).toBe('POST');
    req.flush(dummyResponse);
  });
});
