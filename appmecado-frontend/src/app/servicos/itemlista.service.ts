import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ItemLista } from '../model/ItemLista';

@Injectable({
  providedIn: 'root'
})
export class ItemlistaService {

  constructor(private http: HttpClient) { }

  public adicionarNovoItem(item: ItemLista): Observable<ItemLista>{
    return this.http.post<ItemLista>(environment.apiUrl + "/itemlista", item)
  }
}
