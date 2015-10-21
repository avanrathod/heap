
class heap {
	dataset a[]=new dataset[100];
	int n=-1;
dataset extractMin()
{
	dataset c=a[0];
	a[0]=a[n];
	for(int i=0;2*i+2<=n;)
	{
		//if(a[2*i+1]<=a[2*i+2]&&a[i]>a[2*i+1])
		if(a[2*i+1].comparator(a[2*i+2])&&(a[i].comparator(a[2*i+1])==false))
		{
			dataset k=a[i];
			a[i]=a[2*i+1];
			a[2*i+1]=k;
			i=2*i+1;
		}
		//else if(a[2*i+2]<a[2*i+1]&&a[i]>a[2*i+2])
		else if(a[2*i+1].comparator(a[2*i+2])==false&&(a[i].comparator(a[2*i+2])==false))
		{
			dataset k=a[i];
			a[i]=a[2*i+2];
			a[2*i+2]=k;
			i=2*i+2;
		}
		else
			break;
	}
	n--;
	return c;
}
void insert(dataset k)
{
	
	n++;
	
	a[n]=k;
	for(int i=n;i>=0;)
	{
		int c=(i-1)/2;
		if(a[c].comparator(a[i])==false)
		{
			dataset p=a[c];
			a[c]=a[i];
			a[i]=p;
			i=c;
		}
		else
			break;
	}
}
public static void main(String args[])
{
	//int b[]={30,6,5,11,5,1,4,3,2,1,20};
	int b[]={7,6,4,8,6,0,1,2,5,6,7,8,9,11,1,2,10,5,6};
	heap h=new heap();
	h.n=-1;
	for(int i=0;i<b.length;i++)
	{
		dataset d=new dataset();
		d.i=b[i];
		h.insert(d);
	}
	for(int i=0;i<b.length;i++)
	{
		System.out.println(h.extractMin().i);
//		for(int j=0;j<=h.n;j++)
//			System.out.print(h.a[j]+" ");
//		System.out.println();
	}
}
}
